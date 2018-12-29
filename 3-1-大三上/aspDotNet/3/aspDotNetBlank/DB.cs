using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;
using System.Collections;

namespace QC {
    public class DB{
        public string[] getLatest(int catId) {
            string[] article = new string[6];
            string connstr = ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString;

            SqlConnection sqlConnection = new SqlConnection(connstr);

            sqlConnection.Open();

            if (sqlConnection.State == ConnectionState.Open) {
                SqlDataAdapter dataAdapter = new SqlDataAdapter("SELECT * FROM [article] WHERE cat = " + catId + " AND up_date=(SELECT MAX(up_date) FROM [article] WHERE cat="+catId+")", sqlConnection);

                DataSet dataSet = new DataSet();
                DataRowCollection dataRowCollection;

                dataAdapter.Fill(dataSet, "articles");

                dataRowCollection = dataSet.Tables["articles"].Rows;
                if (dataRowCollection.Count > 0) {
                    article[0] = dataRowCollection[0][0].ToString();
                    article[1] = dataRowCollection[0][1].ToString();
                    article[2] = dataRowCollection[0][2].ToString();
                    article[3] = dataRowCollection[0][3].ToString();
                    article[4] = dataRowCollection[0][4].ToString();
                    article[5] = dataRowCollection[0][5].ToString();
                }
            } else {
                article = null;
            }

            sqlConnection.Close();

            return article;
        }


        public string[] getArticle(int id) {
            string[] article = new string[6];
            string connstr = ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString;

            SqlConnection sqlConnection = new SqlConnection(connstr);

            sqlConnection.Open();

            if (sqlConnection.State == ConnectionState.Open) {
                SqlDataAdapter dataAdapter = new SqlDataAdapter("SELECT * FROM [article] WHERE id = " + id + "", sqlConnection);

                DataSet dataSet = new DataSet();
                DataRowCollection dataRowCollection;

                dataAdapter.Fill(dataSet, "articles");

                dataRowCollection = dataSet.Tables["articles"].Rows;
                if (dataRowCollection.Count > 0) {
                    article[0] = dataRowCollection[0][0].ToString();
                    article[1] = dataRowCollection[0][1].ToString();
                    article[2] = dataRowCollection[0][2].ToString();
                    article[3] = dataRowCollection[0][3].ToString();
                    article[4] = dataRowCollection[0][4].ToString();
                    article[5] = dataRowCollection[0][5].ToString();
                }
            } else {
                article = null;
            }

            sqlConnection.Close();

            return article;
        }


        public ArrayList getArticles(int catId) {
            ArrayList articles;
            string connstr = ConfigurationManager.ConnectionStrings["ConnectionString"].ConnectionString;

            SqlConnection sqlConnection = new SqlConnection(connstr);

            sqlConnection.Open();

            if (sqlConnection.State == ConnectionState.Open) {
                SqlDataAdapter dataAdapter = new SqlDataAdapter("SELECT * FROM [article] WHERE cat = " + catId + "", sqlConnection);

                DataSet dataSet = new DataSet();
                DataRowCollection dataRowCollection;

                articles = new ArrayList();
                dataAdapter.Fill(dataSet, "articles");

                dataRowCollection = dataSet.Tables["articles"].Rows;
                for (int i = 0; i < dataRowCollection.Count; i++) {
                    string[] tmp = new string[6];

                    tmp[0] = dataRowCollection[i][0].ToString();
                    tmp[1] = dataRowCollection[i][1].ToString();
                    tmp[2] = dataRowCollection[i][2].ToString();
                    tmp[3] = dataRowCollection[i][3].ToString();
                    tmp[4] = dataRowCollection[i][4].ToString();
                    tmp[5] = dataRowCollection[i][5].ToString();

                    articles.Add(tmp);
                }
            } else {
                articles = null;
            }

            sqlConnection.Close();

            return articles;
        }
    }
}