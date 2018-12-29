using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QC {
    public partial class Index : System.Web.UI.Page {
        public string[] wx;
        public string[] sx;
        public string[] js;
        public string[] fx;

        protected void Page_Load(object sender, EventArgs e) {
            DB db = new DB();

            wx = db.getLatest(1);
            sx = db.getLatest(2);
            js = db.getLatest(3);
            fx = db.getLatest(4);
        }
    }
}