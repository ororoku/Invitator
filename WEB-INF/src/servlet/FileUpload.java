package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/fileupload")
public class FileUpload extends HttpServlet {

	private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
   req.setCharacterEncoding("UTF-8");
   res.setCharacterEncoding("UTF-8");

   res.setContentType("text/html; charset=UTF-8");

   //保存先のパスを指定
   String path = getServletContext().getRealPath("images");
   File f = new File(path);
   //フォルダなかったら作る
   if(!f.exists()){
     f.mkdirs();
   }
//   ArrayList<String> upedList = new ArrayList<>();
//   ArrayList<String> hashList = new ArrayList<>();
//   File dir = new File(path);
//  // File[] files1 = dir.listFiles();


//   for (File file : files1) {
//     if (file.isFile()){
//       upedList.add(file.getName());
//       InputStream in = new FileInputStream(path+"/"+file.getName());
//     //  hashList.add(md5.digest(in));
//       in.close();
//     }
   //}
   DiskFileItemFactory dfif = new DiskFileItemFactory();
   ServletFileUpload sfu = new ServletFileUpload(dfif);
   sfu.setFileSizeMax(Long.parseLong("4294967296"));

   try {
     List<FileItem> list = sfu.parseRequest(req);
     //String comment;
     for(FileItem item:list){
       // 保存対象のファイルの詳細
     //  if (!item.isFormField()){
         String filename = item.getName();
     //    if ((filename != null) && (!filename.isEmpty())){
           // ファイル名
           filename = (new File(filename)).getName();
           //既に同じファイル名が存在する場合、処理しない。
//           Boolean fg=true;
//           for(String tmp : upedList){
//             if(tmp.equals(filename)){
//               req.setAttribute("existed", "existed");
//               fg=false;
//               break;
//             }
//           }
//           //同じhash値を持つファイルのuploadも許容しない
          // InputStream in = item.getInputStream();
  //         String checker = md5.digest(in);
          // in.close();
          // for(String tmp : hashList){
    //         if(tmp.equals(checker)){
      //         req.setAttribute("hashexist", "hashexist");

        //       fg=false;
          //     break;
            // }
           //}
  //         if(fg==true){
             item.write(new File(path + "/" + filename));
    //       }
           req.setAttribute("filename", filename);
         }
      // }
       //else{
       //  comment = item.getString();
         //comment = new String(comment.getBytes("8859_1"), "UTF-8");
         //req.setAttribute("comment", comment);
       //}
     //}
   }catch (FileUploadException e) {
     e.printStackTrace();
   }
   catch (Exception e) {
     e.printStackTrace();
   }
   String disp = "/fileupload.jsp";
   RequestDispatcher dispatch = req.getRequestDispatcher(disp);
   dispatch.forward(req, res);
 }
}
