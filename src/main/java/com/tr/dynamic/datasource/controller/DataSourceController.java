package com.tr.dynamic.datasource.controller;

import com.tr.dynamic.datasource.config.DataSourceContextHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taorun
 * @date 2022/12/16 17:54
 */
@Api(tags = "数据源")
@RestController
@RequestMapping("/dataSource")
public class DataSourceController {

    @ApiOperation(value = "切换数据源", notes = "db1, db2")
    @GetMapping("/change/{dataSource}")
    public void changeDataSource(@PathVariable String dataSource) {
        DataSourceContextHolder.setDataSource(dataSource);
    }


}
