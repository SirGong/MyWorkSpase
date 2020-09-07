package org.example;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//搭建ES服务器的步骤
public class ElasticDemoTest {
    //和Elasticsearch交互的客户端类
    private RestHighLevelClient client ;
    @Before
    public void initRestHighLevelClient(){
        //初始化RestHighLevelClient
        client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
    }
    private List<Book> loadAll() throws Exception {
        List<Book> bookList=new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/db5?useSSL=true&characterEncoding=utf-8&serverTimezone=UTC";
        Connection conn=DriverManager.getConnection(url,"root","0317gjj");
        PreparedStatement psment=conn.prepareStatement("select * from book");
        ResultSet rs=psment.executeQuery();
        while(rs.next()){
            Book b=new Book();
            b.setBookId(rs.getInt("bookId"));
            b.setBookName(rs.getString("bookName"));
            b.setBookAuthor(rs.getString("bookAuthor"));
            b.setBookPrice(rs.getDouble("bookPrice"));
            b.setBookInfo(rs.getString("bookInfo"));
            bookList.add(b);
        }
        conn.close();
        return bookList;
    }
    @Test
    public void addDate() throws Exception {
        //执行索引名称
        BulkRequest request = new BulkRequest();
        List<Book> bookList = loadAll();
        for(Book book : bookList){
            request.add(new IndexRequest("book").source(XContentType.JSON,
                    "bookId",book.getBookId(),"bookName",book.getBookName(),
                    "bookAuthor",book.getBookAuthor(),"bookPrice",book.getBookPrice(),
                    "bookInfo",book.getBookInfo()));
        }
        BulkResponse responses= client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(responses.status());
    }
}
