//package com.stackroute.WishlistService.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.stackroute.WishlistService.entity.WishList;
//import com.stackroute.WishlistService.exception.StockAlreadyExistException;
//import com.stackroute.WishlistService.exception.StockNotFoundInWishListException;
//import com.stackroute.WishlistService.repository.FavRepo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {FavServiceImpl.class})
//@ExtendWith(SpringExtension.class)
//class FavServiceImplTest {
//    @MockBean
//    private FavRepo favRepo;
//
//    @Autowired
//    private FavServiceImpl favServiceImpl;
//
//
//    @Test
//    void testAddStockToFavList() throws StockAlreadyExistException {
//        WishList wishList = new WishList();
//        wishList.setCountry("GB");
//        wishList.setCurrency("GBP");
//        wishList.setExchange("Exchange");
//        wishList.setFavId(1L);
//        wishList.setName("Name");
//        wishList.setSymbol("Symbol");
//        wishList.setType("Type");
//        wishList.setUserId(1L);
//        Optional<WishList> ofResult = Optional.of(wishList);
//        when(favRepo.findBySymbol(Mockito.<String>any())).thenReturn(ofResult);
//
//        WishList newStock = new WishList();
//        newStock.setCountry("GB");
//        newStock.setCurrency("GBP");
//        newStock.setExchange("Exchange");
//        newStock.setFavId(1L);
//        newStock.setName("Name");
//        newStock.setSymbol("Symbol");
//        newStock.setType("Type");
//        newStock.setUserId(1L);
//        assertThrows(StockAlreadyExistException.class, () -> favServiceImpl.addStockToFavList(newStock));
//        verify(favRepo).findBySymbol(Mockito.<String>any());
//    }
//
//
//    @Test
//    void testAddStockToFavList2() throws StockAlreadyExistException {
//        WishList wishList = new WishList();
//        wishList.setCountry("GB");
//        wishList.setCurrency("GBP");
//        wishList.setExchange("Exchange");
//        wishList.setFavId(1L);
//        wishList.setName("Name");
//        wishList.setSymbol("Symbol");
//        wishList.setType("Type");
//        wishList.setUserId(1L);
//        when(favRepo.save(Mockito.<WishList>any())).thenReturn(wishList);
//        Optional<WishList> emptyResult = Optional.empty();
//        when(favRepo.findBySymbol(Mockito.<String>any())).thenReturn(emptyResult);
//
//        WishList newStock = new WishList();
//        newStock.setCountry("GB");
//        newStock.setCurrency("GBP");
//        newStock.setExchange("Exchange");
//        newStock.setFavId(1L);
//        newStock.setName("Name");
//        newStock.setSymbol("Symbol");
//        newStock.setType("Type");
//        newStock.setUserId(1L);
//        WishList actualAddStockToFavListResult = favServiceImpl.addStockToFavList(newStock);
//        verify(favRepo).findBySymbol(Mockito.<String>any());
//        verify(favRepo).save(Mockito.<WishList>any());
//        assertSame(wishList, actualAddStockToFavListResult);
//    }
//
//
//    @Test
//    void testAddStockToFavList3() throws StockAlreadyExistException {
//        when(favRepo.findBySymbol(Mockito.<String>any()))
//                .thenThrow(new StockNotFoundInWishListException("An error occurred"));
//
//        WishList newStock = new WishList();
//        newStock.setCountry("GB");
//        newStock.setCurrency("GBP");
//        newStock.setExchange("Exchange");
//        newStock.setFavId(1L);
//        newStock.setName("Name");
//        newStock.setSymbol("Symbol");
//        newStock.setType("Type");
//        newStock.setUserId(1L);
//        assertThrows(StockNotFoundInWishListException.class, () -> favServiceImpl.addStockToFavList(newStock));
//        verify(favRepo).findBySymbol(Mockito.<String>any());
//    }
//
//
//    @Test
//    void testDeleteStock() throws StockNotFoundInWishListException {
//        WishList wishList = new WishList();
//        wishList.setCountry("GB");
//        wishList.setCurrency("GBP");
//        wishList.setExchange("Exchange");
//        wishList.setFavId(1L);
//        wishList.setName("Name");
//        wishList.setSymbol("Symbol");
//        wishList.setType("Type");
//        wishList.setUserId(1L);
//        Optional<WishList> ofResult = Optional.of(wishList);
//        doNothing().when(favRepo).deleteById(Mockito.<Long>any());
//        when(favRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        String actualDeleteStockResult = favServiceImpl.deleteStock(1L);
//        verify(favRepo).deleteById(Mockito.<Long>any());
//        verify(favRepo).findById(Mockito.<Long>any());
//        assertEquals("Stock revmoved successfully", actualDeleteStockResult);
//    }
//
//    @Test
//    void testDeleteStock2() throws StockNotFoundInWishListException {
//        WishList wishList = new WishList();
//        wishList.setCountry("GB");
//        wishList.setCurrency("GBP");
//        wishList.setExchange("Exchange");
//        wishList.setFavId(1L);
//        wishList.setName("Name");
//        wishList.setSymbol("Symbol");
//        wishList.setType("Type");
//        wishList.setUserId(1L);
//        Optional<WishList> ofResult = Optional.of(wishList);
//        doThrow(new StockAlreadyExistException("An error occurred")).when(favRepo).deleteById(Mockito.<Long>any());
//        when(favRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
//        assertThrows(StockAlreadyExistException.class, () -> favServiceImpl.deleteStock(1L));
//        verify(favRepo).deleteById(Mockito.<Long>any());
//        verify(favRepo).findById(Mockito.<Long>any());
//    }
//
//
//    @Test
//    void testDeleteStock3() throws StockNotFoundInWishListException {
//        Optional<WishList> emptyResult = Optional.empty();
//        when(favRepo.findById(Mockito.<Long>any())).thenReturn(emptyResult);
//        assertThrows(StockNotFoundInWishListException.class, () -> favServiceImpl.deleteStock(1L));
//        verify(favRepo).findById(Mockito.<Long>any());
//    }
//
//
////    @Test
////    void testGetAllFavStockByUsername() {
////        ArrayList<WishList> wishListList = new ArrayList<>();
////        when(favRepo.findByUserId(Mockito.<Long>any())).thenReturn(wishListList);
////       // List<WishList> actualAllFavStockByUsername = favServiceImpl.getAllFavStockByUsername(1L);
////        verify(favRepo).findByUserId(Mockito.<Long>any());
////        assertTrue(actualAllFavStockByUsername.isEmpty());
////        assertSame(wishListList, actualAllFavStockByUsername);
////    }
//
//
////    @Test
////    void testGetAllFavStockByUsername2() {
////        when(favRepo.findByUserId(Mockito.<Long>any())).thenThrow(new StockAlreadyExistException("An error occurred"));
////        assertThrows(StockAlreadyExistException.class, () -> favServiceImpl.getAllFavStockByUsername(1L));
////        verify(favRepo).findByUserId(Mockito.<Long>any());
////    }
//}
