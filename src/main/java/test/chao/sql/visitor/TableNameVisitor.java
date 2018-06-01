package test.chao.sql.visitor;

import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;

/**
 * 数据库表名访问者
 * 
 * @author xiezhengchao
 * @since 2018/6/1 11:52
 */
public class TableNameVisitor extends MySqlOutputVisitor {

    public TableNameVisitor(Appendable appender) {
        super(appender);
    }

    @Override
    public boolean visit(SQLExprTableSource x) {
        SQLName table = (SQLName) x.getExpr();
        String tableName = table.getSimpleName();

        // 改写tableName
        print0("new_" + tableName.toUpperCase());

        return true;
    }

}
