package com.sutnws.tool;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JFileChooser;
@SuppressWarnings("unused")
public class Print {
	 public void Toprint(){  
	        JFileChooser fileChooser = new JFileChooser(); // ������ӡ��ҵ  
	        File file = new File("D:\\33.txt"); // ��ȡѡ����ļ�  
	        // ������ӡ�������Լ�  
	        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();  
	        // ���ô�ӡ��ʽ����Ϊδȷ�����ͣ�����ѡ��autosense  
	        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
	        // ��λĬ�ϵĴ�ӡ����  
	        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();  
	        InputStream fis = null;  
	        try {  
	            DocPrintJob job = defaultService.createPrintJob(); // ������ӡ��ҵ  
	            fis = new FileInputStream(file); // �������ӡ���ļ���  
	            DocAttributeSet das = new HashDocAttributeSet();  
	            Doc doc = new SimpleDoc(fis, flavor, das);  
	            job.print(doc, pras);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (fis != null) {  
	                try {  
	                    fis.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	    }
	 
}
