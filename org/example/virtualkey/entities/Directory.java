  
package org.example.virtualkey.entities;

import java.util.ArrayList;

public class Directory {
	
	String name;

    ArrayList<File> files = new ArrayList<File>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //gets an arraylist of the files
    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

}