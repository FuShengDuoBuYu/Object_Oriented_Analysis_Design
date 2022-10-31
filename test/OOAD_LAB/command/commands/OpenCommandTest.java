package OOAD_LAB.command.commands;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;
import OOAD_LAB.command.CommandStack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static OOAD_LAB.bookmark.BookmarkTest.initOpenBookmarkCommandTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenCommandTest {
//the test bookmarks structure is:
//|---个人收藏
//
//|   |---课程
//|   |---elearning(https://elearning.fudan.edu.cn/courses)
//
//|   |---参考资料
//|   |---Markdown-Guide(https://www.markdownguide.org)
//
//|   |   |---函数式
//|   |   |---JFP(https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
//
//|   |   |---面向对象
//
//|   |---待阅读
//|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)

//and the text content of the file is:
//
//# 个人收藏
//## 课程
//[elearning](https://elearning.fudan.edu.cn/courses)
//## 参考资料
//[Markdown-Guide](https://www.markdownguide.org)
//### 函数式
//[JFP](https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
//### 面向对象
//## 待阅读
//[Category-Theory](http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)
    @Test
    public void openCommandTest() {
        //we try to read the file and load the bookmarks from the file
        //then we compare the bookmarks with the test bookmarks to check whether the load is successful
        Bookmark bookmark = new Bookmark("",0,new ArrayList<>(),new ArrayList<>());
        Command openCommand = new OpenCommand("/test/OOAD_LAB/command/commands/test.bmk",new Model(bookmark));
        CommandStack.execute(openCommand);
        assertTrue(bookmark.equals(initOpenBookmarkCommandTest()));
    }
}
