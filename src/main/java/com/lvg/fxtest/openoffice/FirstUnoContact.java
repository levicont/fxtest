package com.lvg.fxtest.openoffice;

import com.sun.star.beans.PropertyValue;
import com.sun.star.beans.XPropertySet;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XController;
import com.sun.star.frame.XModel;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.sheet.XSpreadsheet;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.sheet.XSpreadsheetView;
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
    private static final String SPREADSHEET_DOC_URL = "file:///home/lvg/tmp/openoffice-test/tmp.ods";
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
                    xComponentLoader.loadComponentFromURL(SPREADSHEET_DOC_URL,BLANK_STR,0,loadProps);
            XSpreadsheetDocument xSpreadsheetDocument = (XSpreadsheetDocument)
                    UnoRuntime.queryInterface(XSpreadsheetDocument.class, xSpreadsheetComponent);
            XSpreadsheets xSpreadsheets = xSpreadsheetDocument.getSheets();
//            xSpreadsheets.insertNewByName(DEFAULT_SHEET_NAME, (short)0);

            Type elementType = xSpreadsheets.getElementType();
            System.out.println("Element type: "+ elementType.getTypeName());

            Object sheet = xSpreadsheets.getByName(DEFAULT_SHEET_NAME);
            XSpreadsheet xSpreadsheet = (XSpreadsheet)
                    UnoRuntime.queryInterface(XSpreadsheet.class,sheet);
            XCell xCell = xSpreadsheet.getCellByPosition(0, 0);
            //xCell.setValue(24);

            xCell = xSpreadsheet.getCellByPosition(0, 1);
           // xCell.setValue(21);
            xCell = xSpreadsheet.getCellByPosition(0, 2);
           // xCell.setFormula("=sum(A1:A2)");

            XPropertySet xCellProps = (XPropertySet)UnoRuntime.queryInterface(
                    XPropertySet.class, xCell);
            xCellProps.setPropertyValue("CellStyle", "Result");

            XModel xSpreadsheetModel = (XModel)UnoRuntime.queryInterface(
                    XModel.class, xSpreadsheetComponent);
            XController xSpreadsheetController = xSpreadsheetModel.getCurrentController();
            XSpreadsheetView xSpreadsheetView = (XSpreadsheetView)
                    UnoRuntime.queryInterface(XSpreadsheetView.class,
                            xSpreadsheetController);
            xSpreadsheetView.setActiveSheet(xSpreadsheet);


        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            System.exit(0);
        }
    }
}
