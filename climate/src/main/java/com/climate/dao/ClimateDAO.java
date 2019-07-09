package com.climate.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.climate.dto.ClimateDTO;

@Service
public class ClimateDAO implements ClimateDAOInterface {

	private List<ClimateDTO> climates;

	
	 
	 @Override
	public List<ClimateDTO> getData() {

		String file = "/com/climate/source/eng-climate-summary.csv";
		//String file="C:\\dev\\climate\\src\\main\\java\\com\\climate\\source\\eng-climate-summary.csv";
		List<List<String>> records = new ArrayList<>();
		climates = new ArrayList<ClimateDTO>();
		//try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(file)))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				records.add(Arrays.asList(values));
			}

			try {
				int index = 0;
				for (List<String> record : records) {
					if(record.size()==6) {
						ClimateDTO climate = new ClimateDTO();
						climate.setId(index);
						climate.setStationName(record.get(0));
						climate.setProvince(record.get(1));
						Date date = new SimpleDateFormat("dd/MM/yyyy").parse(record.get(2));
						climate.setDate(date);
						climate.setMeanTemp(record.get(3));
						climate.setHightestMonthlymaxiTemp(record.get(4));
						climate.setLowestMonthlyMinTemp(record.get(5));
						//climate.setLink("<a");
						index++;
						climates.add(climate);
					}
				}

				return climates;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return climates;

	}

}
