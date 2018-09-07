package com.staging;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.staging.common.utils.FileUtils;
import com.staging.entity.Permission;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    private ArrayList list;

    @Test
    public void contextLoads() {
    }

    @Before
    public void iniData() {
        list = new ArrayList<>();
        Permission permission = new Permission();
        permission.setDes("5");
        list.add(permission);
    }
}
