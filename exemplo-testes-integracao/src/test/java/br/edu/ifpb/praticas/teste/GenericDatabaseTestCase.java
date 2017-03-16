package br.edu.ifpb.praticas.teste;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.FileInputStream;

/**
 * Created by diogomoreira on 17/07/16.
 */
public abstract class GenericDatabaseTestCase {

    private IDatabaseTester databaseTester;

    @Before
    public void defaultSetUp() throws Exception {
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream((getDataSetFile())));
        databaseTester = new JdbcDatabaseTester("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/dbunit", "dbunit", "123456");
        databaseTester.setDataSet(dataSet);
        databaseTester.setSetUpOperation(DatabaseOperation.INSERT);
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
        databaseTester.onSetup();
    }

    public abstract String getDataSetFile();

    @After
    public void defaultTearDown() throws Exception {
        databaseTester.onTearDown();
    }

}
