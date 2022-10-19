package OOAD_LAB.command.commands;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;
import OOAD_LAB.command.CommandStack;
import org.junit.jupiter.api.Test;

import static OOAD_LAB.bookmark.BookmarkTest.*;
import static OOAD_LAB.bookmark.BookmarkTest.getAfterAddTitleCommandBookMarkTest2;
import static org.junit.jupiter.api.Assertions.assertEquals;


// the test bookmarks structure is:
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

public class AddCommandTest {

    @Test
    public void addTitleCommandAndUndoTest() {
        Bookmark bookmark1 = initAddCommandBookmarkTest();
        Command addCommand1 = new AddCommand(new String[]{"add-title","测试添加标题","at","面向对象"},new Model(bookmark1));
        CommandStack.execute(addCommand1);
        //the after add title bookmarks structure is:
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
        //|   |   |   |---测试添加标题
        //
        //|   |---待阅读
        //|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)
        assertEquals(bookmark1, getAfterAddTitleCommandBookMarkTest1());
        //to see the undo result
        CommandStack.undo();
        assertEquals(bookmark1, initAddCommandBookmarkTest());


        //-----------------------------------------------------------------


        Bookmark bookmark2 = initAddCommandBookmarkTest();
        Command addCommand2 = new AddCommand(new String[]{"add-title","测试添加标题","at","课程"},new Model(bookmark2));
        CommandStack.execute(addCommand2);
        //the after add title bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---elearning(https://elearning.fudan.edu.cn/courses)
        //
        //|   |   |---测试添加标题
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
        assertEquals(bookmark2, getAfterAddTitleCommandBookMarkTest2());
        //to see the undo result
        CommandStack.undo();
        assertEquals(bookmark2, initAddCommandBookmarkTest());
    }

    @Test
    public void addBookmarkAndUndoCommandTest() {
        Bookmark bookmark1 = initAddCommandBookmarkTest();
        Command addCommand1 = new AddCommand(new String[]{"add-bookmark","测试添加书签\"@\"www.baidu.com","at","面向对象"},new Model(bookmark1));
        CommandStack.execute(addCommand1);
        //the after add bookmark bookmarks structure is:
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
        //|   |   |---测试添加书签(www.baidu.com)
        //
        //|   |---待阅读
        //|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)
        assertEquals(bookmark1, getAfterAddBookmarkCommandBookMarkTest1());
        //to see the undo result
        CommandStack.undo();
        assertEquals(bookmark1, initAddCommandBookmarkTest());
    }
}
