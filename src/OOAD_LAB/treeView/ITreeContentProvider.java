package OOAD_LAB.treeView;

public interface ITreeContentProvider {
    public Object[] getChildren(Object parentElement);
    public Object getRoot(Object o);
}
