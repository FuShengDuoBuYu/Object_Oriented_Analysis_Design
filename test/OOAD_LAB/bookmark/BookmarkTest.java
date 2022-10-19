package OOAD_LAB.bookmark;

import javafx.util.Pair;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookmarkTest{

//    public static Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());


    public static Bookmark initAddCommandBookmarkTest(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,4)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,3)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,3)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,3)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterAddTitleCommandBookMarkTest1(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,4)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b4_1 = new Bookmark("测试添加标题",4,new ArrayList<>(),new ArrayList<Bookmark>());

        ArrayList<Bookmark> subBookmark4_1 = new ArrayList<>();
        subBookmark4_1.add(b4_1);
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),subBookmark4_1);
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,3)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,3)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,3)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterAddTitleCommandBookMarkTest2(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,4)));
        Bookmark test = new Bookmark("测试添加标题",3,new ArrayList<>(),new ArrayList<Bookmark>());
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,3)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,3)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,3)));
        ArrayList<Bookmark> testSubBookmarks = new ArrayList<>();
        testSubBookmarks.add(test);
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,testSubBookmarks);
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterAddBookmarkCommandBookMarkTest1(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,4)));

        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());

        List<Pair<String,MarkInfo>> testMarks = new ArrayList<>();
        testMarks.add(new Pair<>("测试添加书签",new MarkInfo("测试添加书签","www.baidu.com",0,false,4)));
        Bookmark b3_2 = new Bookmark("面向对象",3,testMarks,new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,3)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,3)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,3)));

        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark initDeleteCommandBookmarkTest(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,2)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("面向对象",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterDeleteTitleCommandBookMarkTest1(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,2)));
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,2)));
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterDeleteTitleCommandBookMarkTest2(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("面向对象",2,b2_2_marks,b2_2_subBookmarks);

        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterDeleteBookMarkCommandBookMarkTest1(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,2)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("面向对象",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterDeleteMarkCommandBookMarkTest2(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("面向对象",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark initReadBookmarkCommandTest(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",0,false,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,2)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterReadBookmarkCommandTest1(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",0,false,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",1,true,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,2)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterReadBookmarkCommandTest2(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",1,true,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",1,true,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,2)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark getAfterReadBookmarkCommandTest3(){
        Bookmark bookmarkTest = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        ArrayList<Bookmark> subBookmark1_1 = new ArrayList<>();
        List<Pair<String,MarkInfo>> b3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b3_marks.add(new Pair<>("JFP",new MarkInfo("JFP","https://www.cambridge.org/core/journals/journal-of-functionalprogramming",1,true,3)));
        Bookmark b3_1 = new Bookmark("函数式",3,b3_marks,new ArrayList<Bookmark>());
        Bookmark b3_2 = new Bookmark("面向对象",3,new ArrayList<>(),new ArrayList<Bookmark>());
        List<Pair<String,MarkInfo>> b2_1_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_1_marks.add(new Pair<>("elearning",new MarkInfo("elearning","https://elearning.fudan.edu.cn/courses",2,true,2)));
        List<Pair<String,MarkInfo>> b2_2_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_2_marks.add(new Pair<>("Markdown-Guide",new MarkInfo("Markdown-Guide","https://www.markdownguide.org",0,false,2)));
        ArrayList<Bookmark> b2_2_subBookmarks = new ArrayList<>();
        List<Pair<String,MarkInfo>> b2_3_marks = new ArrayList<Pair<String,MarkInfo>>();
        b2_3_marks.add(new Pair<>("Category-Theory",new MarkInfo("Category-Theory","http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/",0,false,2)));
        b2_2_subBookmarks.add(b3_1);
        b2_2_subBookmarks.add(b3_2);
        Bookmark b2_1 = new Bookmark("课程",2,b2_1_marks,new ArrayList<Bookmark>());
        Bookmark b2_2 = new Bookmark("参考资料",2,b2_2_marks,b2_2_subBookmarks);
        Bookmark b2_3 = new Bookmark("待阅读",2,b2_3_marks,new ArrayList<Bookmark>());
        subBookmark1_1.add(b2_1);
        subBookmark1_1.add(b2_2);
        subBookmark1_1.add(b2_3);

        bookmarkTest.addSubBookmark(new Bookmark("个人收藏",1,new ArrayList<>(),subBookmark1_1));
        return bookmarkTest;
    }

    public static Bookmark initOpenBookmarkCommandTest(){
        return initAddCommandBookmarkTest();
    }
}
