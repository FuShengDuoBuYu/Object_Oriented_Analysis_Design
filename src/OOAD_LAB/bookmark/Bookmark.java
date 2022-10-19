package OOAD_LAB.bookmark;

import javafx.util.Pair;

import java.util.*;

public class Bookmark{

    private static Bookmark bookmark = new Bookmark();

    public Bookmark(String title,Integer level,List<Pair<String,MarkInfo>> marks,ArrayList<Bookmark> subBookmark) {
        this.title = title;
        this.level = level;
        this.marks = marks;
        this.subBookmark = subBookmark;
    }

    private Bookmark() {}

    public static Bookmark getInstance(){
        return bookmark;
    }

    private String title = "";
    //the level of this OOAD_LAB.bookmark,the root is 0
    private Integer level = 0;

    private List<Pair<String,MarkInfo>> marks = new ArrayList<>();

    private List<Bookmark> subBookmark = new ArrayList<>();

    //add a new subtitle
    public void addSubBookmark(Bookmark b) {
        subBookmark.add(b);
    }

    public void addSubBookmark(Bookmark b,int index) {
        subBookmark.add(index,b);
    }

    public ArrayList<Bookmark> findBookmarkByTitle(String title) {
        ArrayList<Bookmark> res = new ArrayList<>();
        //self
        if (title.equals(getTitle())) {
            res.add(this);
        }
        //subBookmarks
        for (Bookmark bookmark : subBookmark) {
            res.addAll(bookmark.findBookmarkByTitle(title));
        }
        return res;
    }

    public Bookmark findBookmarkByNode(OperationParentNode node) {
        //use the node's level and title to find the OOAD_LAB.bookmark
        //self
        if (node.getLevel().equals(this.getLevel()) && node.getTitle().equals(this.getTitle())) {
            return this;
        }
        // subBookmark
        for (Bookmark bookmark : this.subBookmark) {
            Bookmark res = bookmark.findBookmarkByNode(node);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    public ArrayList<Bookmark> findBookmarkByMarkKey(String key) {
        ArrayList<Bookmark> res = new ArrayList<>();
        //self
        for (Pair<String,MarkInfo> mark : marks) {
            if (mark.getKey().equals(key)) {
                res.add(this);
            }
        }
        //subBookmarks
        for (Bookmark bookmark : subBookmark) {
            res.addAll(bookmark.findBookmarkByMarkKey(key));
        }
        return res;
    }

    public Map<OperationParentNode, Bookmark> deleteBookmarkByTitle(String title) {
        Map<OperationParentNode, Bookmark> res = new LinkedHashMap<>();
        for (int i = 0; i < subBookmark.size(); i++) {
            if (subBookmark.get(i).getTitle().equals(title)) {
                res.put(new OperationParentNode(this.getLevel(), this.getTitle(),i), subBookmark.get(i));
                subBookmark.remove(i);
                i--;
                continue;
            }
            Map<OperationParentNode, Bookmark> childRes = null;
            if(subBookmark.size()!=0 && i<subBookmark.size()){
                childRes = subBookmark.get(i).deleteBookmarkByTitle(title);
            }
            if (childRes != null && childRes.size() != 0) {
                res.putAll(childRes);
            }
        }
        return res;
    }

    public Integer getLevel() {
        return level;
    }

    public List<Pair<String, MarkInfo>> getMarks() {
        return marks;
    }

    public String getTitle() {
        return title;
    }

    public List<Bookmark> getSubBookmark() {
        return subBookmark;
    }

    public static void setBookmark(Bookmark bookmark) {
        Bookmark.bookmark = bookmark;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setMarks(List<Pair<String, MarkInfo>> marks) {
        this.marks = marks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bookmark getLastSubBookmark() {
        return subBookmark.get(subBookmark.size() - 1);
    }

    public String toString() {
        String res = "";
        //title
        for (int i = 0; i < level; i++) {
            res += "#";
        }
        res += " " + getTitle() + "\n";
        //marks
        for(Pair<String,MarkInfo> pair : marks) {
            res = res + "[" + pair.getKey() + "](" + pair.getValue().getUrl() + ")\n";
        }
        //subBookmarks
        for (Bookmark child : subBookmark) {
            res += child.toString();
        }
        return res;
    }

    public void clearBookMarkInfo() {
        this.marks = new ArrayList<>();
        this.subBookmark = new ArrayList<>();
    }

    public void readBookmark(String bookmarkName) {
        for (Pair<String,MarkInfo> pair : marks) {
            if (pair.getKey().equals(bookmarkName)) {
                pair.getValue().setIsRead(true);
                pair.getValue().setReadCount(pair.getValue().getReadCount() + 1);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookmark bookmark = (Bookmark) o;
        //prepare the marks
        List<Pair<String,MarkInfo>> marks1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> marks2 = new ArrayList<>();
        //sout the marks
        for(Pair<String,MarkInfo> pair : marks1) {
            System.out.println(pair.getKey() + " " + pair.getValue().getUrl());
        }
        for(Pair<String,MarkInfo> pair : marks2) {
            System.out.println(pair.getKey() + " " + pair.getValue().getUrl());
        }

        return Objects.equals(title, bookmark.title) && Objects.equals(level, bookmark.level) && Objects.equals(marks, bookmark.marks) && Objects.equals(subBookmark, bookmark.subBookmark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, level, marks, subBookmark);
    }
}
