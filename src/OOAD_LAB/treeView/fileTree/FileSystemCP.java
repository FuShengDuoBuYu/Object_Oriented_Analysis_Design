package OOAD_LAB.treeView.fileTree;

import java.io.File;

import OOAD_LAB.treeView.ITreeContentProvider;

public class FileSystemCP implements ITreeContentProvider{

    @Override
    public Object[] getChildren(Object parentElement) {
        File currentRoot = new File((String) parentElement);
        //get the current root's children
        File[] files = currentRoot.listFiles();
        if (files == null) {
            return null;
        }
        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getPath();
        }
        return fileNames;
    }

    @Override
    public Object getRoot(Object o) {
        File rootPath = new File((String)o);
        return rootPath.getPath();
    }

}
