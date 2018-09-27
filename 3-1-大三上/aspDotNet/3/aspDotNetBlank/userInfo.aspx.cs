using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace aspDotNetBlank {
    public partial class userInfo : System.Web.UI.Page {
        public string name = "";
        public string gender = "";
        public int age = 0;
        public string department = "";
        public float salary = 0;
        public string nation = "";
        public string remarks = "";

        protected void Page_Load(object sender, EventArgs e) {
            name = Request.Form["name"];
            gender = Request.Form["gender"] == "1" ? "男" : "女";
            age = int.Parse(Request.Form["age"]);
            department = Request.Form["department"];
            salary = float.Parse(Request.Form["salary"]);
            nation = Request.Form["nation"];
            remarks = Request.Form["remarks"];
        }
    }
}