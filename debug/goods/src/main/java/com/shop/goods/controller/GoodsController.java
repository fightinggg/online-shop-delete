package com.shop.goods.controller;

import com.shop.common.annotation.ResponseEncode;
import com.shop.common.annotation.enable.EnableResponseEncodeAutoConfigration;
import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.common.exception.NoFoundException;
import com.shop.goods.entity.Goods;
import com.shop.goods.entity.GoodsVO;
import com.shop.goods.service.GoodsService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "商品微服务")
@Slf4j
@EnableResponseEncodeAutoConfigration
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ResponseEncode
    @PostMapping("/")
    @ApiOperation(value = "创建一个商品", notes = "传入商品的详细信息")
    @ApiImplicitParam(name = "sendGoods", value = "商品信息", dataType = "SendGoods", required = true)
    public Object post(@ApiIgnore @RequestHeader int id, @RequestBody GoodsVO goodsVO)
            throws NoAuthorityException, FallbackException {
        System.out.println(goodsVO);
        log.info("用户{}创建商品{}", id, goodsVO.getGoods().getName());
        return goodsService.post(id, goodsVO);
    }


    @ResponseEncode
    @DeleteMapping("/{goodsId}")
    @ApiOperation(value = "删除一个商品", notes = "传入商品的ID")
    @ApiImplicitParam(name = "goodsId", value = "商品ID", dataType = "int", required = true)
    public Object delete(@ApiIgnore @RequestHeader int id, @PathVariable int goodsId)
            throws NoAuthorityException, NoFoundException {
        log.info("用户{}删除商品{}", id, goodsId);
        return goodsService.delete(id, goodsId);
    }


    @ResponseEncode
    @PutMapping("/")
    @ApiOperation(value = "修改一个商品", notes = "传入商品的新信息，老信息如果不变，可以不传")
    @ApiImplicitParam(name = "sendGoods", value = "商品信息", dataType = "SendGoods", required = true)
    public Object put(@ApiIgnore @RequestHeader int id, @RequestBody GoodsVO goodsVO)
            throws NoAuthorityException, FallbackException, NoFoundException {
        log.info("用户{}修改商品{}", id, goodsVO.getGoods().getId());
        return goodsService.put(id, goodsVO);
    }


    @ResponseEncode
    @GetMapping("/{goodsId}")
    @ApiOperation(value = "查询一个商品的详细信息", notes = "传入商品id即可")
    @ApiImplicitParam(name = "goodsId", value = "商品ID", dataType = "int", required = true)
    public Object get(@ApiIgnore @RequestHeader @Nullable Integer id,
                      @PathVariable int goodsId)
            throws NoFoundException {
        log.info("用户{}浏览商品{}的详细信息", id, goodsId);
        return goodsService.get(goodsId);
    }

    @ResponseEncode
    @PutMapping("/{goodsId}/{count}")
    @ApiOperation(value = "增加一个商品的余量", notes = "传入商品的ID和增加的余量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品ID", dataType = "int", required = true),
            @ApiImplicitParam(name = "count", value = "商品增加量", dataType = "int", required = true)
    })
    public Object addCount(@ApiIgnore @RequestHeader int id, @PathVariable int goodsId, @PathVariable int count) {
        log.info("用户{}增加了{}个商品{}", id, count, goodsId);
        return goodsService.addCount(id, goodsId, count);
    }


    @ResponseEncode
    @GetMapping("/count/{goodsId}")
    @ApiOperation(value = "获得一个商品的余量", notes = "传入商品的ID")
    @ApiImplicitParam(name = "goodsId", value = "商品ID", dataType = "int", required = true)
    public Object getCount(@ApiIgnore @RequestHeader(required = false) Object id,
                           @PathVariable int goodsId) {
        log.info("用户{}获得商品{}的余量", id, goodsId);
        return goodsService.getCount(goodsId);
    }


    @ResponseEncode
    @GetMapping("/{pageBegin}/{perPage}")
    @ApiOperation(value = "分页查询商品", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageBegin", value = "页面开始的下标", dataType = "int", required = true),
            @ApiImplicitParam(name = "perPage", value = "页面元素的个数", dataType = "int", required = true)
    })
    public Object getByPage(@ApiIgnore @RequestHeader(required = false) Object id,
                            @PathVariable int pageBegin,
                            @PathVariable int perPage) {
        log.info("用户{}分页查询了一次商品", id);
        return goodsService.getByPage(pageBegin, perPage);
    }


    @ResponseEncode
    @GetMapping("/seller/{sellerId}/{pageBegin}/{perPage}")
    @ApiOperation(value = "根据卖家查询全部商品分页", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sellerId", value = "卖家ID", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageBegin", value = "页面开始的下标", dataType = "int", required = true),
            @ApiImplicitParam(name = "perPage", value = "页面元素的个数", dataType = "int", required = true)
    })
    public Object getBySeller(@ApiIgnore @RequestHeader(required = false) Object id,
                              @PathVariable int sellerId,
                              @PathVariable int pageBegin,
                              @PathVariable int perPage) {
        log.info("用户{}分页查询了一次商家{}的商品", id, sellerId);
        return goodsService.getBySeller(sellerId, pageBegin, perPage);
    }

    @ResponseEncode
    @GetMapping("/category/{pageBegin}/{perPage}")
    @ApiOperation(value = "根据类型查询分页", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "类型", dataType = "string", required = true),
            @ApiImplicitParam(name = "pageBegin", value = "页面开始的下标", dataType = "int", required = true),
            @ApiImplicitParam(name = "perPage", value = "页面元素的个数", dataType = "int", required = true)
    })
    public Object getByCategory(@ApiIgnore @RequestHeader(required = false) Object id,
                                @RequestBody String category,
                                @PathVariable int pageBegin,
                                @PathVariable int perPage) {
        log.info("用户{}分页查询了一次类型{}的商品", id, category);
        return goodsService.getByCategory(category, pageBegin, perPage);
    }
}


