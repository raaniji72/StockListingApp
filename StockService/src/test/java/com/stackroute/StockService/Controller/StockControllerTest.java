//package com.stackroute.StockService.Controller;
//
//
//
//import com.stackroute.StockService.Service.StockService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//@ExtendWith(MockitoExtension.class)
//class StockControllerTest {
//    @InjectMocks
//    StockController stockController;
//
//    @Mock
//    StockService stockService;
//
//    @Test
//    void testGetStocksByCountryName() {
//        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.CREATED);
//        Mockito.when(stockService.getStocksByCountryName("india")).thenReturn(responseEntity);
//        stockController.getStocksByCountryName("india");
//
//    }
//
//    @Test
//    void testGetStocksByCountryName_Exception() {
//        Mockito.when(stockService.getStocksByCountryName("india")).thenThrow(new RuntimeException());
//        stockController.getStocksByCountryName("india");
//
//    }
//}
