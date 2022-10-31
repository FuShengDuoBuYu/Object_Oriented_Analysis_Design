package OOAD_LAB.command.commands;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;
import OOAD_LAB.command.CommandStack;
import org.junit.jupiter.api.Test;

import static OOAD_LAB.bookmark.BookmarkTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DeleteCommandTest {
// the test bookmarks structure is:
//|---个人收藏
//
//|   |---课程
//|   |---elearning(https://elearning.fudan.edu.cn/courses)
//
//|   |---面向对象
//|   |---Markdown-Guide(https://www.markdownguide.org)
//
//|   |   |---函数式
//|   |   |---JFP(https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
//
//|   |   |---面向对象
//
//|   |---待阅读
//|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)

    @Test
    public void deleteTitleCommandAndUndoTest() {
        Bookmark bookmark1 = initDeleteCommandBookmarkTest();
        Command deleteCommand1 = new DeleteCommand(new String[]{"delete-title","面向对象"},new Model(bookmark1));
        CommandStack.execute(deleteCommand1);
        //the after delete title bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---elearning(https://elearning.fudan.edu.cn/courses)
        //
        //|   |   |---函数式
        //|   |   |---JFP(https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
        //
        //|   |---待阅读
        //|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)
        assertEquals(bookmark1, getAfterDeleteTitleCommandBookMarkTest1());
        //to see the undo result
        CommandStack.undo();
        assertEquals(bookmark1, initDeleteCommandBookmarkTest());

        Bookmark bookmark2 = initDeleteCommandBookmarkTest();
        Command deleteCommand2 = new DeleteCommand(new String[]{"delete-title","待阅读"},new Model(bookmark2));
        CommandStack.execute(deleteCommand2);
        //the after delete title bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---elearning(https://elearning.fudan.edu.cn/courses)
        //
        //|   |---面向对象
        //|   |---Markdown-Guide(https://www.markdownguide.org)
        //
        //|   |   |---函数式
        //|   |   |---JFP(https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
        //
        //|   |   |---面向对象
        assertEquals(bookmark2, getAfterDeleteTitleCommandBookMarkTest2());
        //to see the undo result
        CommandStack.undo();
        assertEquals(bookmark2, initDeleteCommandBookmarkTest());

    }

    @Test
    public void deleteBookMarkCommandAndUndoTest() {
        Bookmark bookmark1 = initDeleteCommandBookmarkTest();
        Command deleteCommand1 = new DeleteCommand(new String[]{"delete-bookmark","JFP"},new Model(bookmark1));
        CommandStack.execute(deleteCommand1);
        //the after delete mark bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---elearning(https://elearning.fudan.edu.cn/courses)
        //
        //|   |---面向对象
        //|   |---Markdown-Guide(https://www.markdownguide.org)
        //
        //|   |   |---函数式
        //
        //|   |   |---面向对象
        //
        //|   |---待阅读
        //|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)
        assertEquals(bookmark1, getAfterDeleteBookMarkCommandBookMarkTest1());
        //to see the undo result
        CommandStack.undo();
        assertEquals(bookmark1, initDeleteCommandBookmarkTest());

        Bookmark bookmark2 = initDeleteCommandBookmarkTest();
        Command deleteCommand2 = new DeleteCommand(new String[]{"delete-bookmark","Category-Theory"},new Model(bookmark2));
        CommandStack.execute(deleteCommand2);
        //the after delete mark bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---elearning(https://elearning.fudan.edu.cn/courses)
        //
        //|   |---面向对象
        //|   |---Markdown-Guide(https://www.markdownguide.org)
        //
        //|   |   |---函数式
        //|   |   |---JFP(https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
        //
        //|   |   |---面向对象
        //
        //|   |---待阅读
        assertEquals(bookmark2, getAfterDeleteMarkCommandBookMarkTest2());
        //to see the undo result
        CommandStack.undo();
        assertEquals(bookmark2, initDeleteCommandBookmarkTest());

    }
}
