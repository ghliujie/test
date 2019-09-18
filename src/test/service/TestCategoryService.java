package service;

import com.ljlover.travel.domain.Category;
import com.ljlover.travel.service.CategoryService;
import com.ljlover.travel.service.impl.CategoryServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/9 7:24
 * All rights reserved.
 */

public class TestCategoryService {

    @Test
    public void testfindAll(){

        CategoryService categoryService = new CategoryServiceImpl();

        List<Category> all = categoryService.findAll();

    }

}
