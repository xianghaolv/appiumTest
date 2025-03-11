package utils;

import com.lxh.utils.LoggerUtils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//获取csv文件内容
public class CsvDataProvider {

    @DataProvider(name = "getApiData")
    public Object[][] getGetApiData(){
        return readCsvData("src/resources/data/getApiTestData.csv");
    }

    @DataProvider(name = "postApiData")
    public Object[][] getPostApiData(){
        return readCsvData("src/resources/data/postApiTestData.csv.csv");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        return readCsvData("src/resources/data/login-data.csv");
    }

    public static Object[][] readCsvData(String filePath) {
        ArrayList<Object[]> data = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isFirstLine = true;
            while ((line = reader.readNext()) != null){
                if(isFirstLine){
                    isFirstLine = false;
                    continue;
                }
                data.add(line);
            }
        }catch (IOException | CsvValidationException e){
            LoggerUtils.logError("Failed loading datas ....",e.getMessage());
        }
        return data.toArray(new Object[0][]);
    }
}
