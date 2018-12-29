using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QC {
    public partial class Article : System.Web.UI.Page {
        public string[] article;

        protected void Page_Load(object sender, EventArgs e) {
            DB db = new DB();

            article = db.getArticle(Convert.ToInt32(Request["id"]));
        }
    }
}