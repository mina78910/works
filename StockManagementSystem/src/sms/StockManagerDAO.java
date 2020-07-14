package sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;

public class StockManagerDAO {
	//インスタンスオブジェクトを返却させてコードの簡略化
    public static StockManagerDAO getInstance(){
        return new StockManagerDAO();
    }

    public void insert(ItemDataBeans idb) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO item(name,stock) VALUES(?,?)");
            st.setString(1, idb.getName());
            st.setInt(2, idb.getStock());

            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }

    public List<ItemDataBeans> searchAll() throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();

//            //修正箇所：入力された検索値を保持するための空のリストをつくる
//            List<Object> parameters = new ArrayList<>();

            //flagを使う理由は、whereかandで始まるか分からないため
            String sql = "SELECT * FROM item";
//            boolean flag = false;
//            if (!searchCondition.getName().equals("")) {
//                sql += " WHERE name like ?";
//                flag = true;
//                //修正箇所 配列に値を代入
//                parameters.add("%"+searchCondition.getName()+"%");
//            }
//            if (searchCondition.getBirthday()!=null) {
//                if(!flag){
//                    sql += " WHERE birthday like ?";
//                    flag = true;
//                }else{
//                    sql += " AND birthday like ?";
//                }
//                //修正箇所　配列に値を代入
//                parameters.add("%"+ new SimpleDateFormat("yyyy").format(searchCondition.getBirthday())+"%");
//
//            }
//            if (searchCondition.getType()!=0) {
//                if(!flag){
//                    sql += " WHERE type like ?";
//                }else{
//                    sql += " AND type like ?";
//                }
//                //修正箇所　配列に値を代入
//                parameters.add(searchCondition.getType());
//            }
//
//            	//昇順出力を指定
//            	sql += " order by userID asc; ";

            	System.out.println("search用のsqlを送信する直前 :(sqlの中身)"+sql);

	            //出来上がったSQL文をセット
	            st =  con.prepareStatement(sql);

//            //修正箇所
//            for(int i=0;i<parameters.size();i++) {
//            	//sqlに値をループで回しながらセット
//            	st.setObject(i+1, parameters.get(i));
//            }



            //SQL送信して、ヒットしたレコード結果が丸々rsに入っている
            ResultSet rs = st.executeQuery();

            //DBから複数のレコード検索し、ヒットしたレコードをすべて保持するためのlistを定義
            List<ItemDataBeans> result = new ArrayList<>();

            //rs.next();だけだと、1行分しか読まないので、次の行が見つからなくなるまでスキャン
            while(rs.next()) {
            	//dtoの空箱用意
            	ItemDataBeans idb = new ItemDataBeans();
            	//左から順番に値をとってきて、idbに代入
            	idb.setItem_id(rs.getInt(1));
            	idb.setName(rs.getString(2));
            	idb.setStock(rs.getInt(3));
            	//テーブルをスキャンして、値をDTOに格納する、そしてdtoをリストに代入
            	result.add(idb);

            }
            System.out.println("searchAll completed");

            //複数のヒットしたレコードの値を持つDTOを配列にしたので、戻す
            return result;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }

    public ItemDataBeans searchByID(ItemDataBeans idb) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            //SQL原文を用意
            String sql = "SELECT * FROM item WHERE item_id = ?";
            st =  con.prepareStatement(sql);
            //SQLへidだけセット
            st.setInt(1, idb.getItem_id());
            //SQL送信
            ResultSet rs = st.executeQuery();
            System.out.println((rs).toString());
            rs.next();
            //検索結果の値を保持するbeansを新規生成
            ItemDataBeans willUpdateData = new ItemDataBeans();
            willUpdateData.setItem_id(rs.getInt(1));
            willUpdateData.setName(rs.getString(2));
            willUpdateData.setStock(rs.getInt(3));
            System.out.println(rs.getString(2));

            System.out.println("searchByID completed");

            return willUpdateData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }

    public void update(ItemDataBeans willUpdateToDB) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            System.out.println("DAO内、update()171");
            String sql ="update item set name= ?,stock= ? where item_id =? ;";
            st =  con.prepareStatement(sql);
            st.setString(1, willUpdateToDB.getName());
            st.setInt(2, willUpdateToDB.getStock());
            st.setInt(3, willUpdateToDB.getItem_id());
            System.out.println("DAO内、update()175のsql送信直前"+ st.toString());
            //SQL送信
            st.executeUpdate();
            System.out.println("update completed");

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }


    public boolean login(UserDataBeans loginData) throws SQLException{

        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            //SQL原文を用意
            String sql = "SELECT * FROM account WHERE id = ? AND pass =?";
            st =  con.prepareStatement(sql);
            //SQLへidだけセット
            st.setInt(1, loginData.getId());
            st.setString(2, loginData.getPass());

            //SQL送信と同時にRSに検索結果が返ってくる
            ResultSet rs = st.executeQuery();
            System.out.println((rs).toString());

            System.out.println("searchByID completed");

            //rs.next();を1回実行すると、true or false を返す
            return rs.next();

        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }



}
