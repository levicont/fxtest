package com.lvg.fxtest.openoffice;

import com.sun.star.beans.PropertyValue;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.sheet.XSpreadsheet;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.sheet.XSpreadsheets;
import com.sun.star.table.XCell;
import com.sun.star.uno.Type;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

/**
 * Created by Victor Levchenko LVG Corp. on 15.11.2020.
 */
public class FirstUnoContact {
    private static final String DESKTOP_SERVICE = "com.sun.star.frame.Desktop";
    private static final String SPREADSHEET_COMPONENT_URL = "private:factory/scalc";
    private static final String BLANK_STR = "_blank";
    private static final String DEFAULT_SHEET_NAME = "MySheet";

    public static void main(String[] args) {
        try{
            XComponentContext xRemoteContext = Bootstrap.bootstrap();
            if (xRemoteContext == null) {
                System.err.println("ERROR: Could not bootstrap default Office.");
            }
            System.out.println("Connected to a running office ...");

            XMultiComponentFactory xRemoteContextServiceManager = xRemoteContext.getServiceManager();
            String available = (xRemoteContextServiceManager != null ?"available":"not available");
            System.out.println("Office is "+available);

            Object desktop = xRemoteContextServiceManager.createInstanceWithContext(DESKTOP_SERVICE,xRemoteContext);
            XComponentLoader xComponentLoader = (XComponentLoader)
                    UnoRuntime.queryInterface(XComponentLoader.class,desktop);
            PropertyValue[] loadProps = new PropertyValue[0];
            XComponent xSpreadsheetComponent =
                    xComponentLoader.loadComponentFromURL(SPREADSHEET_COMPONENT_URL,BLANK_STR,0,loadProps);
            XSpreadsheetDocument xSpreadsheetDocument = (XSpreadsheetDocument)
                    UnoRuntime.queryInterface(XSpreadsheetDocument.class, xSpreadsheetComponent);
            XSpreadsheets xSpreadsheets = xSpreadsheetDocument.getSheets();
            xSpreadsheets.insertNewByName(DEFAULT_SHEET_NAME, (short)0);

            Type elementType = xSpreadsheets.getElementType();
            System.out.println("Element type: "+ elementType.getTypeName());

            Object sheet = xSpreadsheets.getByName(DEFAULT_SHEET_NAME);
            XSpreadsheet xSpreadsheet = (XSpreadsheet)
                    UnoRuntime.queryInterface(XSpreadsheet.class,sheet);
            XCell xCell = xSpreadsheet.getCellByPosition(0,0);
            xCell.setValue(24);


        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            System.exit(0);
        }
    }
}
