/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import model.FileCompressionModel;
import view.FileCompressionView;

/**
 *
 * @author ADMIN
 */
public class FileCompressionController {

    public FileCompressionController(FileCompressionView view) {
        this.view = view;
    }
    public FileCompressionView view;

    

    public void start() {
        while (true) {
            view.displayMessage("1. Compression");
            view.displayMessage("2. Extraction");
            view.displayMessage("3. Exit");
            int choice = Integer.parseInt(view.getInput("Enter your choice:"));

            switch (choice) {
                case 1:
                    zipFile();
                    break;
                case 2:
                    unzipFile();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void zipFile() {
        String pathSrc = view.getInput("Enter Source Folder: ");
        String pathCompress = view.getInput("Enter Destination Folder: ");
        String fileZipName = view.getInput("Enter Name: ");

        try {
            boolean check = FileCompressionModel.compressTo(pathSrc, fileZipName, pathCompress);
            if (check) {
                view.displayMessage("Successfully");
            } else {
                view.displayMessage("Fail");
            }
        } catch (IOException e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    public void unzipFile() {
        String pathZipFile = view.getInput("Enter Source file: ");
        String pathExtract = view.getInput("Enter Destination Folder: ");

        try {
            boolean check = FileCompressionModel.extractTo(pathZipFile, pathExtract);
            if (check) {
                view.displayMessage("Successfully");
            } else {
                view.displayMessage("Fail");
            }
        } catch (IOException e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }
}

