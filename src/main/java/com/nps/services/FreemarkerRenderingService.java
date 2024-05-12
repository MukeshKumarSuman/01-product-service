package com.nps.services;

import com.nps.models.Product;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@Service
public class FreemarkerRenderingService {
    private final Configuration freemarkerConfiguration;

    public FreemarkerRenderingService(Configuration freemarkerConfiguration) {
        this.freemarkerConfiguration = freemarkerConfiguration;
    }

    public byte[] generatePdf() throws TemplateException, IOException {
        Product p = new Product();
        p.setTitle("My demo");
        p.setPrice(100);
        String content = render("demo.ftl", p);
        return htmlToPdf(content);
    }

    private byte[] htmlToPdf(String content) throws FileNotFoundException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ITextRenderer iTextRenderer = new ITextRenderer();
        iTextRenderer.getSharedContext().getTextRenderer().setSmoothingThreshold(0f);
        iTextRenderer.setDocumentFromString(content);
        iTextRenderer.layout();
        iTextRenderer.createPDF(byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();


    }

    private String render(String templateName, Product product) throws IOException, TemplateException {
        Objects.requireNonNull(templateName, "templateName");
        Objects.requireNonNull(product, "model");

        Template template = loadTemplate(templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, product);
    }

    private Template loadTemplate(String templateName) throws IOException {
        return freemarkerConfiguration.getTemplate(templateName);
    }
}
