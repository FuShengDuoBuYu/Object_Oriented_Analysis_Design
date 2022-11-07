package OOAD_LAB.treeView;

import java.util.ArrayList;

public class TreeViewer {
    private ITreeContentProvider contentProvider;
    private INameProvider nameProvider;
    public TreeViewer(ITreeContentProvider contentProvider, INameProvider nameProvider) {
        this.contentProvider = contentProvider;
        this.nameProvider = nameProvider;
    }

    public ArrayList<String> printTree(Object o,boolean ifLast,ArrayList<Boolean> ifLastList) {
        ArrayList<String> result = new ArrayList<>();
        Object root = contentProvider.getRoot(o);
        String[] rootName = nameProvider.getName(root).split(" ");
        String s = addSpaceByLevel(rootName[0], Integer.valueOf(rootName[1]), ifLast,ifLastList);
        System.out.println(s);
        result.add(s);
        Object[] children = contentProvider.getChildren(root);
        if (children != null) {
            for (Object child : children) {
                ifLastList.add(child == children[children.length - 1]);
                ArrayList<String> childRes = printTree(child, child == children[children.length - 1],ifLastList);
                if(childRes!=null){
                    result.addAll(childRes);
                }
                ifLastList.remove(ifLastList.size()-1);
            }
        }
        return result;
    }

    private String addSpaceByLevel(String name,int level,boolean ifLast,ArrayList<Boolean> ifLastList) {
        String res = "";
        for(int i=0;i<level;i++){
            if(i==level-1){
                if(ifLast){
                    res = res+"└──";
                }
                else{
                    res = res+"├──";
                }
            }
            else{
                if(i+1== ifLastList.size()){

                }
                else{
                    if(ifLastList.get(i+1)){
                        res = res+"    ";
                    }
                    else{
                        res = res+"│   ";
                    }
                }
            }
        }
        res = res+name;
        return res;
    }
}
