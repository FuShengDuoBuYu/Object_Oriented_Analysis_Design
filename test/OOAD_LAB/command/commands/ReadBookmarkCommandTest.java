package OOAD_LAB.command.commands;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.bookmark.MarkInfo;
import OOAD_LAB.command.Command;
import OOAD_LAB.command.CommandStack;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import static OOAD_LAB.bookmark.BookmarkTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadBookmarkCommandTest {
    Bookmark bookmark1 = initReadBookmarkCommandTest();
    Model model = new Model(bookmark1);
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
    @Test
    public void readBookmarkCommandTest1() {


        Command readCommand1 = new ReadBookmarkCommand("elearning",model);
        CommandStack.execute(readCommand1);
        //the after read bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---*elearning[1](https://elearning.fudan.edu.cn/courses)
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
        assertEquals(bookmark1, getAfterReadBookmarkCommandTest1());
    }

    @Test
    public void readBookmarkCommandTest2() {
        Command readCommand1 = new ReadBookmarkCommand("elearning",model);
        CommandStack.execute(readCommand1);
        Command readCommand2 = new ReadBookmarkCommand("JFP",model);
        CommandStack.execute(readCommand2);
        //the after read bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---*elearning[1](https://elearning.fudan.edu.cn/courses)
        //
        //|   |---参考资料
        //|   |---Markdown-Guide(https://www.markdownguide.org)
        //
        //|   |   |---函数式
        //|   |   |---*JFP[1](https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
        //
        //|   |   |---面向对象
        //
        //|   |---待阅读
        //|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)
        assertEquals(bookmark1, getAfterReadBookmarkCommandTest2());
    }

    @Test
    public void readBookmarkCommandTest3() {
        Bookmark bookmark1 = initReadBookmarkCommandTest();
        Model model = new Model(bookmark1);
        Command readCommand1 = new ReadBookmarkCommand("elearning",model);
        CommandStack.execute(readCommand1);
        CommandStack.execute(readCommand1);
        Command readCommand2 = new ReadBookmarkCommand("JFP",model);
        CommandStack.execute(readCommand2);
        //the after read bookmarks structure is:
        //|---个人收藏
        //
        //|   |---课程
        //|   |---*elearning[2](https://elearning.fudan.edu.cn/courses)
        //
        //|   |---参考资料
        //|   |---Markdown-Guide(https://www.markdownguide.org)
        //
        //|   |   |---函数式
        //|   |   |---*JFP[1](https://www.cambridge.org/core/journals/journal-of-functionalprogramming)
        //
        //|   |   |---面向对象
        //
        //|   |---待阅读
        //|   |---Category-Theory(http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)
        MarkInfo markInfo = null;
        for (Pair<String, MarkInfo> pair : bookmark1.findBookmarkByTitle("课程").get(0).getMarks()) {
            if(pair.getKey().equals("elearning")) {
                markInfo = pair.getValue();
            }
        }
        ShowTreeCommand showTreeCommand = new ShowTreeCommand(bookmark1);
        showTreeCommand.execute();
        System.out.println(markInfo.getReadCount());
        ShowTreeCommand showTreeCommand1 = new ShowTreeCommand(getAfterReadBookmarkCommandTest3());
        showTreeCommand1.execute();
        assertEquals(bookmark1, getAfterReadBookmarkCommandTest3());
    }
}
