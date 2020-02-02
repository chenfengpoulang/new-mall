package com.mall.control;

import com.alibaba.fastjson.JSONObject;
import com.mall.page.EsPage;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.web.bind.annotation.*;

import com.mall.utils.ElasticsearchUtil;

@RestController
@RequestMapping("search")
public class SearchOutControl {

    @RequestMapping(value = "createIndex")
    public boolean createIndex(@RequestParam  String index) {
        return ElasticsearchUtil.createIndex(index);
    }

    @RequestMapping(value = "addData",method = RequestMethod.POST)
    public String addData(@RequestBody JSONObject jsonObject,@RequestParam String index,@RequestParam String type,@RequestParam String id) {
        return ElasticsearchUtil.addData(jsonObject,index,type,id);
    }

    @RequestMapping(value = "deleteDataById")
    public void deleteDataById(@RequestParam String index, @RequestParam String type, @RequestParam String id) {
        ElasticsearchUtil.deleteDataById(index,type,id);
    }

    @RequestMapping(value = "updateDataById",method = RequestMethod.POST)
    public  void updateDataById(@RequestBody  JSONObject jsonObject,@RequestParam String index, @RequestParam  String type, @RequestParam String id) {

        ElasticsearchUtil.updateDataById(jsonObject,index,type,id);
    }

    @RequestMapping(value = "searchDataPage",method = RequestMethod.POST)
    public  EsPage searchDataPage(@RequestParam String index, @RequestParam String type, @RequestParam int startPage, @RequestParam int pageSize, @RequestParam boolean matchPhrase, @RequestParam String searchField, @RequestParam String sortField, @RequestParam String highlightField, @RequestParam String searchword,@RequestParam String viewsField) {
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
            if (matchPhrase == Boolean.TRUE) {
                //不进行分词搜索
                boolQuery.must(QueryBuilders.matchPhraseQuery(searchField, searchword));
            } else {
                boolQuery.must(QueryBuilders.matchQuery(searchField, searchword));
            }
            EsPage esPage = ElasticsearchUtil.searchDataPage(index, type, startPage, pageSize,boolQuery, viewsField, sortField, highlightField);
            return esPage;
    }

}
