using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections;

namespace QC {
    public partial class List : System.Web.UI.Page {
        public ArrayList articles;

        protected void Page_Load(object sender, EventArgs e) {
            DB db = new DB();

            articles = db.getArticles(Convert.ToInt32(Request["cat"]));
        }
    }
}