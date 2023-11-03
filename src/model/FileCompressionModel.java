package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class FileCompressionModel {

    //check 
    public int checkIntLimit(int min, int max) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Re-input!!!");
            }

        }
    }

    public String checkString() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine().trim();
                if (str.length() == 0) {
                    throw new NumberFormatException();
                }
                return str;
            } catch (NumberFormatException e) {
                System.err.println("Not empty!!!");
            }
        }
    }

    private String pathSrc; // Declare pathSrc 
    private String pathZipFile; // Declare pathZipFile 

   

    public void zipFile() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Source Folder: ");
        pathSrc = checkString(); // Assign the value to the class member
        System.out.print("Enter Destination Folder: ");
        String pathCompress = checkString();
        System.out.print("Enter Name: ");
        String fileZipName = in.nextLine();

        boolean check = compressTo(pathSrc, fileZipName, pathCompress);
        if (check) {
            System.out.println("Successfully");
        } else {
            System.out.println("Fail");
        }
    }

    public void unzipFile() throws IOException {
        System.out.print("Enter Source file: ");
        pathZipFile = checkString(); // Assign the value to the class member
        System.out.print("Enter Destination Folder: ");
        String pathExtract = checkString();
        boolean check = extractTo(pathZipFile, pathExtract);
        if (check) {
            System.out.println("Successfully");
        } else {
            System.out.println("Fail");
        }
    }

    public boolean compressTo(String sourceFile, String fileZipName, String pathCompress)
            throws IOException {
        // String sourceFile = pathSrc; // Remove this line
        String nameFos = pathCompress + "/" + fileZipName + ".zip";
        FileOutputStream fos = new FileOutputStream(nameFos);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        final byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
        return true;
    }

    public boolean extractTo(String pathExtract, String pathExtract1) throws IOException {
        String fileZip = pathZipFile; // Use the class member pathZipFile
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            String fileName = zipEntry.getName();
            File newFile = new File(pathExtract + fileName);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        return true;
    }
}

