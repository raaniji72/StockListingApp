//package com.stackroute.WishlistService.controller;
//
//import static org.mockito.Mockito.anyLong;
//import static org.mockito.Mockito.when;
//
//
//import com.stackroute.WishlistService.entity.WishList;
//import com.stackroute.WishlistService.service.FavServiceImpl;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {FavController.class})
//@ExtendWith(SpringExtension.class)
//class FavControllerTest {
//    @Autowired
//    private FavController favController;
//
//    @MockBean
//    private FavServiceImpl favServiceImpl;
//
//
//    @Test
//    void testAddTofavList() throws Exception {
//        WishList wishList = new WishList();
//        wishList.setCountry("GB");
//        wishList.setCurrency("GBP");
//        wishList.setExchange("Exchange");
//        wishList.setFavId(1L);
//        wishList.setName("Name");
//        wishList.setSymbol("Symbol");
//        wishList.setType("Type");
//        wishList.setUserId(1L);
//        when(favServiceImpl.addStockToFavList(Mockito.<WishList>any())).thenReturn(wishList);
//        favController.addTofavList(wishList);
//    }
//
//
//    @Test
//    void testRemoveFromFavList() throws Exception {
//        when(favServiceImpl.deleteStock(anyLong())).thenReturn("Delete Stock");
//        favController.removeFromFavList(1L);
//    }
//
//
////    @Test
////    void testViewAllStock_for_empty() throws Exception {
////        when(favServiceImpl.getAll(Mockito.<Long>any())).thenReturn(new ArrayList<>());
////        favController.viewAllStock(1L);
////    }
//
//
////    @Test
////    void testViewAllStock2() throws Exception {
////        WishList wishList = new WishList();
////        wishList.setCountry("GB");
////        wishList.setCurrency("GBP");
////        wishList.setExchange("Exchange");
////        wishList.setFavId(1L);
////        wishList.setName("Name");
////        wishList.setSymbol("Symbol");
////        wishList.setType("Type");
////        wishList.setUserId(1L);
////
////        ArrayList<WishList> wishListList = new ArrayList<>();
////        wishListList.add(wishList);
////     //   when(favServiceImpl.getAllFavStockByUsername(Mockito.<Long>any())).thenReturn(wishListList);
////        favController.viewAllStock(1L);
////    }
//}