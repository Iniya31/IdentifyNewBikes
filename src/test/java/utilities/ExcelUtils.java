package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static void appendCarDetail(
            String fileName,
            String sheetName,
            String carName,
            String price) throws IOException {
        FileInputStream fi = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(sheetName);
        if (ws == null) {
            ws = wb.createSheet(sheetName);
        }
        int lastRow = ws.getLastRowNum();
        if (lastRow == 0 && ws.getRow(0) == null) {
            XSSFRow header = ws.createRow(0);
            header.createCell(0).setCellValue("Car Name");
            header.createCell(1).setCellValue("Price");
            lastRow = 0;
        }
        XSSFRow row = ws.createRow(lastRow + 1);
        row.createCell(0).setCellValue(carName);
        row.createCell(1).setCellValue(price);
        fi.close();
        FileOutputStream fo = new FileOutputStream(fileName);
        wb.write(fo);
        fo.close();
        wb.close();
    }
    public static int getLastRowNumber(String fileName, String sheetName) throws IOException {
        FileInputStream fi = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(sheetName);
        int rows = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rows;
    }
    public static String getCellValue(String fileName, String sheetName, int rowNum, int cellNum) throws IOException {
        FileInputStream fi = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(sheetName);
        XSSFRow row = ws.getRow(rowNum);
        String value = "";
        if (row != null && row.getCell(cellNum) != null) {
            DataFormatter formatter = new DataFormatter();
            value = formatter.formatCellValue(row.getCell(cellNum));
        }
        wb.close();
        fi.close();
        return value;
    }
    public static void appendUnder3LakhCar(String fileName, String sheetName, String carName) throws IOException {
        FileInputStream fi = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(sheetName);
        if (ws == null) {
            ws = wb.createSheet(sheetName);
            XSSFRow header = ws.createRow(0);
            header.createCell(0).setCellValue("Car Name");
        }
        int lastRow = ws.getLastRowNum();
        System.out.println("Writing Row : " + (lastRow + 1) + " Car : " + carName);
        XSSFRow row = ws.createRow(lastRow + 1);
        row.createCell(0).setCellValue(carName);
        fi.close();
        FileOutputStream fo = new FileOutputStream(fileName);
        wb.write(fo);
        fo.close();
        wb.close();
    }

    public static void appendBikeDetail(String fileName, String sheetName, String bikeName, String price, String launchDate) throws IOException {
        FileInputStream fi = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(sheetName);
        if (ws == null) {
            ws = wb.createSheet(sheetName);
            XSSFRow header = ws.createRow(0);
            header.createCell(0).setCellValue("Bike Name");
            header.createCell(1).setCellValue("Price");
            header.createCell(2).setCellValue("Expected Launch");
        }
        int lastRow = ws.getLastRowNum();
        XSSFRow row = ws.createRow(lastRow + 1);
        row.createCell(0).setCellValue(bikeName);
        row.createCell(1).setCellValue(price);
        row.createCell(2).setCellValue(launchDate);
        fi.close();
        FileOutputStream fo = new FileOutputStream(fileName);
        wb.write(fo);
        fo.close();
        wb.close();
    }

    public static void appendUnder4LakhBike(String fileName, String sheetName, String bikeName, String price, String launchDate) throws IOException {
        FileInputStream fi = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(sheetName);
        if (ws == null) {
            ws = wb.createSheet(sheetName);
            XSSFRow header = ws.createRow(0);
            header.createCell(0).setCellValue("Bike Name");
            header.createCell(1).setCellValue("Price");
            header.createCell(2).setCellValue("Expected Launch");
        }
        int lastRow = ws.getLastRowNum();
        XSSFRow row = ws.createRow(lastRow + 1);
        row.createCell(0).setCellValue(bikeName);
        row.createCell(1).setCellValue(price);
        row.createCell(2).setCellValue(launchDate);
        fi.close();
        FileOutputStream fo = new FileOutputStream(fileName);
        wb.write(fo);
        fo.close();
        wb.close();
    }


}