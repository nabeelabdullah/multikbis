package com.website.resume;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NABEEL
 */
public class MakeResume {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    private static Font redFont = new Font(Font.FontFamily.COURIER, 12,
            Font.NORMAL, BaseColor.BLACK);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);

    public static void main(String atr[]) {
        try {
            MakeResume rm = new MakeResume();
            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            document.setMargins(5, 5, 1, 1);

            PdfWriter.getInstance(document, new FileOutputStream("D:\\nabeel.pdf"));

            document.open();
            Paragraph p = new Paragraph("Resume", subFont);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MakeResume.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(MakeResume.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nameCreater(Document document, String name) throws DocumentException {
        Paragraph ph = new Paragraph(name, catFont);
        document.add(ph);
    }

    public void couresMobile(Document document, String course, String mobile) throws DocumentException {
        Paragraph ph = new Paragraph();
        PdfPTable pt = new PdfPTable(2);
        pt.setSpacingBefore(2);
        pt.setWidthPercentage(100);
        PdfPCell c1 = new PdfPCell(new Phrase(course, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        pt.addCell(c1);
        c1 = new PdfPCell(new Phrase(mobile, redFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setBorderColor(BaseColor.WHITE);
        pt.addCell(c1);
        ph.add(pt);
        document.add(ph);
    }

    public void collageEmail(Document document, String college, String email) throws DocumentException {
        Paragraph ph = new Paragraph();
        PdfPTable pt = new PdfPTable(2);
        pt.setSpacingBefore(1);
        pt.setWidthPercentage(100);
        PdfPCell c1 = new PdfPCell(new Phrase(college, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        pt.addCell(c1);
        Paragraph pm = new Paragraph(email, redFont);

        c1 = new PdfPCell(pm);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setBorderColor(BaseColor.WHITE);
        pt.addCell(c1);
        ph.add(pt);
        document.add(ph);

    }

    public PdfPTable tableCreatre(int size) throws DocumentException {
        PdfPTable table = new PdfPTable(size);
        table.setWidthPercentage(100);
        int a[] = {300, 600, 400, 200};
        table.setWidths(a);
        return table;
    }

    public void cellCreater(PdfPTable table) {
        PdfPCell pc = new PdfPCell(new Phrase("Year", catFont));
        pc.setPadding(4);

        pc.setVerticalAlignment(Element.ALIGN_CENTER);
        pc.setHorizontalAlignment(Element.ALIGN_CENTER);
        pc.setBackgroundColor(new BaseColor(204, 204, 204));

        table.addCell(pc);
        pc = new PdfPCell(new Phrase("Institute", catFont));
        pc.setPadding(4);

        pc.setVerticalAlignment(Element.ALIGN_CENTER);
        pc.setHorizontalAlignment(Element.ALIGN_CENTER);
        pc.setBackgroundColor(new BaseColor(204, 204, 204));

        table.addCell(pc);
        pc = new PdfPCell(new Phrase("Degree", catFont));
        pc.setPadding(4);

        pc.setVerticalAlignment(Element.ALIGN_CENTER);
        pc.setHorizontalAlignment(Element.ALIGN_CENTER);
        pc.setBackgroundColor(new BaseColor(204, 204, 204));

        table.addCell(pc);

        pc = new PdfPCell(new Phrase("Percentage", catFont));
        pc.setPadding(4);

        pc.setVerticalAlignment(Element.ALIGN_CENTER);
        pc.setHorizontalAlignment(Element.ALIGN_CENTER);
        pc.setBackgroundColor(new BaseColor(204, 204, 204));

        table.addCell(pc);

    }

    public void addrecordintable(PdfPTable table, String value) {
        PdfPCell pc = new PdfPCell(new Phrase(value, smallBold));
        pc.setPadding(3);

        pc.setVerticalAlignment(Element.ALIGN_CENTER);

        table.addCell(pc);

    }

    public void spectialDivider(Document document, String value) throws DocumentException {

        PdfPTable table1 = new PdfPTable(1);

        table1.setWidthPercentage(100);
        PdfPCell pp = new PdfPCell(new Phrase(value, catFont));
        pp.setBackgroundColor(new BaseColor(204, 204, 204));
        pp.setPadding(4);
        pp.setBorderColor(BaseColor.WHITE);
        table1.addCell(pp);
        document.add(table1);
        Paragraph p = new Paragraph();
        p.setSpacingAfter(7);
        document.add(p);
    }

    public void title(Document document, String title) throws DocumentException {
        Paragraph ph = new Paragraph();
        Chunk c1 = new Chunk("Title: ", catFont);
        Chunk c2 = new Chunk(title, smallBold);
        ph.add(c1);
        ph.add(c2);
        ph.setSpacingAfter(2);
        document.add(ph);

    }

    public void technologyused(Document document, String title) throws DocumentException {
        Paragraph ph = new Paragraph();
        Chunk c1 = new Chunk("Technologies used: ", catFont);
        Chunk c2 = new Chunk(title, smallBold);
        ph.add(c1);
        ph.add(c2);
        ph.setSpacingAfter(2);
        document.add(ph);

    }

    public void teamSize(Document document, String title) throws DocumentException {
        Paragraph ph = new Paragraph();
        Chunk c1 = new Chunk("Team size: ", catFont);
        Chunk c2 = new Chunk(title, smallBold);
        ph.add(c1);
        ph.add(c2);
        ph.setSpacingAfter(2);
        document.add(ph);

    }

    public void Role(Document document, String title) throws DocumentException {
        Paragraph ph = new Paragraph();
        Chunk c1 = new Chunk("Role: ", catFont);
        Chunk c2 = new Chunk(title, smallBold);
        ph.add(c1);
        ph.add(c2);
        ph.setSpacingAfter(2);
        document.add(ph);

    }

    public void Description(Document document, String title) throws DocumentException {
        Paragraph ph = new Paragraph();
        Chunk c1 = new Chunk("Description: ", catFont);
        Chunk c2 = new Chunk(title, smallBold);
        ph.add(c1);
        ph.add(c2);
        ph.setSpacingAfter(2);
        document.add(ph);

    }

    public void summertranning(Document document, String time, String from, String on) throws DocumentException {
        Paragraph ph = new Paragraph();
        Chunk c = new Chunk(time + " summer training from " + from + " on " + on, smallBold);
        ph.add(c);
        ph.setIndentationLeft(10);
        document.add(ph);
    }

    public void computerskill(Document document, String os, String lang, String Ide, String db) throws DocumentException {

        PdfPTable pt = new PdfPTable(2);
        pt.setWidthPercentage(100);
        int a[] = {100, 100};
        pt.setWidths(a);
        PdfPCell c1;
        /* first cell o/s*/
        if (!os.equals("not found")) {
            c1 = new PdfPCell(new Phrase("Operation System:", catFont));
            c1.setBorderColor(BaseColor.WHITE);
            c1.setPaddingTop(3);
            pt.addCell(c1);
            /* first cell o/s userdef*/

            c1 = new PdfPCell(new Phrase(os, smallBold));
            c1.setBorderColor(BaseColor.WHITE);
            c1.setPaddingTop(3);
            pt.addCell(c1);
        }
        // document.add(pt);

        /* second cell lan */
        if (!lang.equals("not found")) {
            c1 = new PdfPCell(new Phrase("Programming Language", catFont));
            c1.setBorderColor(BaseColor.WHITE);

            c1.setPaddingTop(3);
            pt.addCell(c1);
            // document.add(pt);

            /* second cell lan userdef */
            c1 = new PdfPCell(new Phrase(lang, smallBold));
            c1.setBorderColor(BaseColor.WHITE);
            c1.setPaddingTop(3);
            pt.addCell(c1);
        }
        // document.add(pt);

        /* second cell IDE */
        if (!Ide.equals("not found")) {
            c1 = new PdfPCell(new Phrase("IDE", catFont));
            c1.setBorderColor(BaseColor.WHITE);
            c1.setPaddingTop(3);
            pt.addCell(c1);
            //  document.add(pt);

            /* second cell IDE userdef */
            c1 = new PdfPCell(new Phrase(Ide, smallBold));
            c1.setBorderColor(BaseColor.WHITE);
            c1.setPaddingTop(3);
            pt.addCell(c1);
        }
        // document.add(pt);

        /* second cell database */
        if (!db.equals("not found")) {
            c1 = new PdfPCell(new Phrase("Datatbase", catFont));
            c1.setBorderColor(BaseColor.WHITE);
            c1.setPaddingTop(3);

            pt.addCell(c1);

            //  document.add(pt);

            /* second cell database userdef */
            c1 = new PdfPCell(new Phrase(db, smallBold));
            c1.setBorderColor(BaseColor.WHITE);

            pt.setSpacingAfter(10);
            pt.addCell(c1);
        }
        document.add(pt);

    }

    public void personalInfo(Document document, String f_name, String nation, String gender, String marrege, String dob, String lan, String p_Add) throws DocumentException {

        Paragraph ph = new Paragraph("");

        document.add(ph);
        ph = new Paragraph();
        PdfPTable pt = new PdfPTable(2);
        pt.setWidthPercentage(100);

        /**
         * for father name *
         */
        PdfPCell c1 = new PdfPCell(new Phrase("Father Name  ", catFont));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        c1 = new PdfPCell(new Phrase(f_name, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        /**
         * End of father *
         */
        /**
         * for national name *
         */
        c1 = new PdfPCell(new Phrase("Nationalty    ", catFont));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setBackgroundColor(new BaseColor(230, 230, 230));
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        c1 = new PdfPCell(new Phrase(nation, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setBackgroundColor(new BaseColor(230, 230, 230));
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        /**
         * End of natioonal *
         */
        /**
         * for gender name *
         */
        c1 = new PdfPCell(new Phrase("Gender    ", catFont));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        c1 = new PdfPCell(new Phrase(gender, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        /**
         * End of gender *
         */
        /**
         * for national name *
         */
        c1 = new PdfPCell(new Phrase("Marital status    ", catFont));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setBackgroundColor(new BaseColor(230, 230, 230));
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        c1 = new PdfPCell(new Phrase(marrege, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setBackgroundColor(new BaseColor(230, 230, 230));
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        /**
         * End of natioonal *
         */
        /**
         * for national name *
         */
        c1 = new PdfPCell(new Phrase("Date of Birth    ", catFont));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        c1 = new PdfPCell(new Phrase(dob, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        /**
         * End of natioonal *
         */
        /**
         * for national name *
         */
        c1 = new PdfPCell(new Phrase("Languages known    ", catFont));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        c1.setBackgroundColor(new BaseColor(230, 230, 230));
        pt.addCell(c1);

        c1 = new PdfPCell(new Phrase(lan, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setBackgroundColor(new BaseColor(230, 230, 230));
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        /**
         * End of natioonal *
         */
        /**
         * for national name *
         */
        c1 = new PdfPCell(new Phrase("Permanent Address    ", catFont));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        c1 = new PdfPCell(new Phrase(p_Add, smallBold));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPaddingBottom(4);
        pt.addCell(c1);

        /**
         * End of natioonal *
         */
        ph.add(pt);
        document.add(ph);
    }

    public Paragraph formateCreater(String deg, int year) {
        Paragraph p = new Paragraph();
        p.setFont(smallBold);
        Chunk degree = new Chunk(deg, smallBold);
        Chunk how = new Chunk(" " + year);
        Chunk yea = new Chunk(" year", smallBold);
        Chunk c;
        if (year % 10 == 0) {
            c = new Chunk("", smallBold);
        } else if (year % 10 == 1) {
            c = new Chunk("st", smallBold);
        } else if (year % 10 == 2) {
            c = new Chunk("nd", smallBold);
        } else if (year % 10 == 3) {
            c = new Chunk("rd", smallBold);
        } else {
            c = new Chunk("th", smallBold);
        }
        c.setTextRise(5f);
        p.add(deg);
        p.add(how);
        p.add(c);
        p.add(yea);
        return p;

    }

    public Paragraph school(String sc) {
        return new Paragraph(sc, smallBold);
    }

    public void addRow(PdfPTable table, String year, String Institude, Paragraph Degree, String Percent, int i) {
        PdfPCell c = new PdfPCell(new Phrase(year, smallBold));
        BaseColor b;
        if (i % 2 == 0) {
            b = new BaseColor(230, 230, 230);
        } else {
            b = new BaseColor(255, 255, 255);
        }
        c.setBackgroundColor(b);
        c.setPaddingBottom(3);
        table.addCell(c);

        c = new PdfPCell(new Phrase(Institude, smallBold));
        c.setBackgroundColor(b);
        c.setPaddingBottom(3);
        table.addCell(c);
        c = new PdfPCell(Degree);
        c.setBackgroundColor(b);
        c.setPaddingBottom(3);
        table.addCell(c);
        c = new PdfPCell(new Phrase(Percent, smallBold));
        c.setPaddingBottom(3);
        c.setBackgroundColor(b);
        table.addCell(c);
    }

    public void MakeResumeMaker(HashMap mp, String path) {
        try {
            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            document.setMargins(5, 5, 1, 1);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            Paragraph p = new Paragraph("Resume", subFont);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            nameCreater(document, mp.get("full_name").toString());
            couresMobile(document, mp.get("choose").toString() + mp.get("choose_branch").toString(), mp.get("mobile").toString());
            collageEmail(document, mp.get("gr_name").toString(), mp.get("email").toString());
            space(document);
            PdfPTable table = tableCreatre(4);
            cellCreater(table);

            if (!mp.get("gr_4_p").toString().equals("")) {
                addRow(table, mp.get("gr_4_d").toString(), mp.get("gr_name").toString(), formateCreater(mp.get("choose").toString(), 4), mp.get("gr_4_p").toString() + "%", 4);
            }
            addRow(table, mp.get("gr_3_d").toString(), mp.get("gr_name").toString(), formateCreater(mp.get("choose").toString(), 3), mp.get("gr_3_p").toString() + "%", 3);
            addRow(table, mp.get("gr_2_d").toString(), mp.get("gr_name").toString(), formateCreater(mp.get("choose").toString(), 2), mp.get("gr_2_p").toString() + "%", 2);
            addRow(table, mp.get("gr_1_d").toString(), mp.get("gr_name").toString(), formateCreater(mp.get("choose").toString(), 1), mp.get("gr_1_p").toString() + "%", 1);
            addRow(table, mp.get("s_s_d").toString(), mp.get("s_s_name").toString(), school("Senior Secondry"), mp.get("s_s_p").toString() + "%", 6);
            addRow(table, mp.get("h_s_d").toString(), mp.get("h_s_name").toString(), school("High School"), mp.get("h_s_p").toString() + "%", 5);

            document.add(table);
            space(document);

            /*  Majer Projects  */
            spectialDivider(document, "Major Project:");
            title(document, mp.get("t_project").toString());
            technologyused(document, mp.get("tech_project").toString());
            Description(document, mp.get("d_project").toString());
            teamSize(document, mp.get("team_project").toString());
            Role(document, mp.get("roll_project").toString());
            space(document);
            /* / Majer Projects  */

            spectialDivider(document, "Summer Training: ");
            summertranning(document, mp.get("trainning_d").toString(), mp.get("trainning_ind").toString(), mp.get("trainning_on").toString());
            space(document);
            if (mp.get("c_skill_enable").toString().equals("true")) {
                spectialDivider(document, "Computer  Skill :");
                computerskill(document, mp.get("c_skill_os").toString(), mp.get("c_skill_pr").toString(), mp.get("c_skill_ide").toString(), mp.get("c_skill_db").toString());
            }
   if (mp.get("skill_enable").toString().equals("true")) {
            spectialDivider(document, "Skill :");
            XMLWorkerHelper work = XMLWorkerHelper.getInstance();
   
            work.parseXHtml(writer, document, new StringReader(mp.get("skilltext").toString()));
           // space(document);
   }
            spectialDivider(document, "Personal Credentials:");
            personalInfo(document, mp.get("father_name").toString(), mp.get("nationality").toString(), mp.get("gender").toString(), mp.get("marital").toString(), mp.get("d_o_b").toString(), mp.get("l_known").toString(), mp.get("p_add").toString());

            document.close();
        } catch (FileNotFoundException ex) {

        } catch (DocumentException ex) {

        } catch (IOException ex) {
            Logger.getLogger(MakeResume.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void space(Document document) throws DocumentException {
        Paragraph p = new Paragraph(" ");
        document.add(p);
    }

}
