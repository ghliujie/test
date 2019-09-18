package com.ljlover.travel.web.servlet;

import com.ljlover.travel.domain.ResultInfo;
import com.ljlover.travel.domain.User;
import com.ljlover.travel.service.UserService;
import com.ljlover.travel.service.impl.UserServiceImpl;
import com.ljlover.travel.util.BeanUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * @Program teavel
 * @Description: 完成用户的访问的功能
 * @Author: ljlover
 * @Date: 2019/8/8 14:44
 * All rights reserved.
 */

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    /**
     * 激活状态码  未激活
     */
    private static final String N = "N";

    /**
     * 激活状态码  激活
     */
    private static final String Y = "Y";


    private static UserService userService = new UserServiceImpl();


    /**
     * 注册用户
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo resultInfo = null;

        // 验证码校验
        HttpSession session = request.getSession();
        String checkCodeServer = (String) session.getAttribute("CHECK_CODE_SERVER");
        session.removeAttribute("CHECK_CODE_SERVER");

        String check = request.getParameter("check");

        System.out.println(check);
        System.out.println(checkCodeServer);
        if (checkCodeServer == null || !checkCodeServer.equalsIgnoreCase(check)) {
            resultInfo = new ResultInfo(false, "验证码错误");
            writeValue(resultInfo, response);
            return;
        }
        // 获得数据
        Map<String, String[]> map = request.getParameterMap();

        // 封装数据到user
        User user = BeanUtil.populate(map);

        // 获得注册结果信息
        boolean flag = userService.regist(user);
        System.out.println(flag);

        if (flag) {
            resultInfo = new ResultInfo(true);
        } else {
            resultInfo = new ResultInfo(false, "注册失败！");
        }
        writeValue(resultInfo, response);
    }


    /**
     * 校验验证码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");

        if (code != null) {

            boolean flag = userService.active(code);

            String message = null;
            if (flag) {
                message = "激活成功，请登录<a href='../login.html'>【登录】</a>";
            } else {
                message = "激活失败，请联系管理员。";
            }

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(message);
        } else {
            System.out.println("没有激活码");
        }

    }


    /**
     * 查询一个用户
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object user = request.getSession().getAttribute("user");

        writeValue(user, response);
    }


    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();

        User user = BeanUtil.populate(map);

        User loginUser = userService.login(user);


        ResultInfo resultInfo = null;

        if (loginUser == null) {
            resultInfo = new ResultInfo(false, "账号或者密码错误");

        }

        if (loginUser != null && N.equals(loginUser.getStatus())) {
            resultInfo = new ResultInfo(false, "账号未激活，请登录邮箱激活");

        }

        if (loginUser != null && Y.equals(loginUser.getStatus())) {
            resultInfo = new ResultInfo(true);
            request.getSession().setAttribute("user", loginUser);
        }

        writeValue(resultInfo, response);
    }


    /**
     * 退出登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath() + "/login.html");
    }


    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0, 0, width, height);

        //产生4个随机验证码
        String checkCode = getCheckCode();

        //将验证码放入HttpSession中
        request.getSession().setAttribute("CHECK_CODE_SERVER", checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));

        //向图片上写入验证码
        g.drawString(checkCode, 15, 25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    /**
     * 产生4位随机字符串
     */
    private String getCheckCode() {

        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        int size = base.length();

        Random r = new Random();

        StringBuffer buffer = new StringBuffer();

        for (int i = 1; i <= 4; i++) {

            //产生0到size-1的随机值
            int index = r.nextInt(size);

            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);

            //将c放入到StringBuffer中去
            buffer.append(c);
        }
        return buffer.toString();
    }

}
