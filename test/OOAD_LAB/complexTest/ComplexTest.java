package OOAD_LAB.complexTest;

import OOAD_LAB.Model;
import OOAD_LAB.bookmark.Bookmark;
import OOAD_LAB.command.Command;
import OOAD_LAB.command.CommandStack;
import OOAD_LAB.command.commands.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ComplexTest {

    //这个测试用例包括了add,delete,undo,redo,read,show-tree等命令的组合测试
    //偏向于基本命令的实现测试
    @Test
    public void complexTest1(){
        Bookmark initBookmark = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        Model model = new Model(initBookmark);
        Command addCommand1 = new AddCommand(new String[]{"add-title","标题","at",""},model);
        Command addCommand2 = new AddCommand(new String[]{"add-title","标题1","at","标题"},model);
        Command addCommand3 = new AddCommand(new String[]{"add-bookmark","FDU\"@\"https://www.fudan.edu.cn","at","标题1"},model);
        Command addCommand4 = new AddCommand(new String[]{"add-title","标题1.1","at","标题1"},model);
        //执行命令(add)
        CommandStack.execute(addCommand1);
        CommandStack.execute(addCommand2);
        CommandStack.execute(addCommand3);
        CommandStack.execute(addCommand4);
        //判断结果
        Assertions.assertEquals(initBookmark.toString(),
                " \n" +
                        "# 标题\n" +
                        "## 标题1\n" +
                        "[FDU](https://www.fudan.edu.cn)\n" +
                        "### 标题1.1\n"
        );

        Command deleteCommand1 = new DeleteCommand(new String[]{"delete-bookmark","FDU"},model);
        Command deleteCommand2 = new DeleteCommand(new String[]{"delete-title","标题1"},model);
        //执行命令(delete)
        CommandStack.execute(deleteCommand1);
        CommandStack.execute(deleteCommand2);
        //判断结果
        Assertions.assertEquals(initBookmark.toString(),
                " \n" +
                        "# 标题\n"
        );

        CommandStack.undo();
        CommandStack.undo();
        //判断结果(undo)
        Assertions.assertEquals(initBookmark.toString(),
                " \n" +
                        "# 标题\n" +
                        "## 标题1\n" +
                        "[FDU](https://www.fudan.edu.cn)\n" +
                        "### 标题1.1\n"
        );

        CommandStack.redo();
        //判断结果(redo)
        Assertions.assertEquals(initBookmark.toString(),
                " \n" +
                        "# 标题\n" +
                        "## 标题1\n" +
                        "### 标题1.1\n"
        );
        CommandStack.undo();

        Command readCommand1 = new ReadBookmarkCommand("FDU",model);
        Command readCommand2 = new ReadBookmarkCommand("FDUCS",model);
        //执行命令(read)
        CommandStack.execute(readCommand1);
        CommandStack.execute(readCommand2);
        //判断结果
        ShowTreeCommand showTreeCommand = new ShowTreeCommand(initBookmark);
        ArrayList<String> printRes = new ArrayList<>();
        printRes = showTreeCommand.execute(printRes);
        //遍历printRes,转为String
        String printResStr = "";
        for(String str:printRes){
            printResStr += (str+"\n");
        }
        //判断结果
        Assertions.assertEquals(printResStr,
                        "\n"
                +"└──标题\n" +
                        "    └──标题1\n" +
                        "        ├──\"*FDU\"\n" +
                        "        └──标题1.1\n"
        );
    }


    //本测试用例包括了open,ls-tree,save等关于文件存储以及树的显示的命令的组合测试
    //偏向于文件存储以及树的显示的命令的实现测试
    @Test
    public void complexTest2(){
        Bookmark initBookmark = new Bookmark("",0,new ArrayList<>(),new ArrayList<Bookmark>());
        Model model = new Model(initBookmark);
        Command OpenCommand = new OpenCommand("./test/OOAD_LAB/test_bookmark/test.bmk",model);
        CommandStack.execute(OpenCommand);
        //判断结果(open)
        Assertions.assertEquals(initBookmark.toString(),
                        " \n"
                +"# 个人收藏\n" +
                        "## 课程\n" +
                        "[elearning](https://elearning.fudan.edu.cn/courses)\n" +
                        "## 参考资料\n" +
                        "[Markdown-Guide](https://www.markdownguide.org)\n" +
                        "### 函数式\n" +
                        "[JFP](https://www.cambridge.org/core/journals/journal-of-functionalprogramming)\n" +
                        "### 面向对象\n" +
                        "## 待阅读\n" +
                        "[Category-Theory](http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)\n"

        );

        //判断结果(ls-tree)
        LsTreeCommand lsTreeCommand = new LsTreeCommand("test/OOAD_LAB/test_bookmark");
        ArrayList<String> printRes = new ArrayList<>();
        printRes = lsTreeCommand.execute(printRes);
        //遍历printRes,转为String
        String printResStr = "";
        for(String str:printRes){
            printResStr += (str+"\n");
        }
        //判断结果(ls-tree)
        Assertions.assertEquals(printResStr,
                        "└──test_bookmark\n" +
                                "    └──\"test.bmk\"\n"
        );

        Command saveCommand = new SaveCommand("test/OOAD_LAB/test_bookmark/test_save.bmk",model);
        CommandStack.execute(saveCommand);

        //判断结果(save)
        //比较test_save.bmk中的文件的内容
        File file = new File("test/OOAD_LAB/test_bookmark/test_save.bmk");
        String fileContent = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                fileContent += (line+"\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(fileContent,
                        " \n"
                +"# 个人收藏\n" +
                        "## 课程\n" +
                        "[elearning](https://elearning.fudan.edu.cn/courses)\n" +
                        "## 参考资料\n" +
                        "[Markdown-Guide](https://www.markdownguide.org)\n" +
                        "### 函数式\n" +
                        "[JFP](https://www.cambridge.org/core/journals/journal-of-functionalprogramming)\n" +
                        "### 面向对象\n" +
                        "## 待阅读\n" +
                        "[Category-Theory](http://www.appliedcategorytheory.org/what-is-appliedcategory-theory/)\n"
        );

        //删除test_save.bmk
        file.delete();
    }
}
