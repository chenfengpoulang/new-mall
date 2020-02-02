package com.mall.service;

import com.alibaba.fastjson.JSONObject;
import com.mall.page.EsPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mall-search")
public interface SearchService {

    @RequestMapping(value = "search/createIndex")
    public boolean createIndex(@RequestParam(value = "index") String index);

    @RequestMapping(value = "search/addData",method = RequestMethod.POST)
    public String addData(@RequestBody JSONObject jsonObject, @RequestParam(value = "index") String index, @RequestParam(value = "type") String type, @RequestParam(value = "id") String id) ;

    @RequestMapping(value = "search/deleteDataById")
    public void deleteDataById(@RequestParam(value = "index") String index, @RequestParam(value = "type") String type, @RequestParam(value = "id") String id);

    @RequestMapping(value = "search/updateDataById",method = RequestMethod.POST)
    public void updateDataById(@RequestBody JSONObject jsonObject, @RequestParam(value = "index") String index, @RequestParam(value = "type") String type, @RequestParam(value = "id") String id);

    @RequestMapping(value = "search/searchDataPage",method = RequestMethod.POST)
    public EsPage searchDataPage(@RequestParam(value = "index") String index, @RequestParam(value = "type") String type, @RequestParam(value = "startPage") int startPage, @RequestParam(value = "pageSize") int pageSize, @RequestParam(value = "matchPhrase") boolean matchPhrase, @RequestParam(value = "searchField") String searchField, @RequestParam(value = "sortField") String sortField, @RequestParam(value = "highlightField") String highlightField, @RequestParam(value = "searchword") String searchword, @RequestParam(value = "viewsField") String viewsField) ;
}
