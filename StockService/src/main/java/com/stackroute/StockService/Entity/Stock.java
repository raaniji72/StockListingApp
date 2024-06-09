package com.stackroute.StockService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Setter
@Getter
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	private ArrayList<Data> data = new ArrayList<>() ;

}
