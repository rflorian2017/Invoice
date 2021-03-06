package com.tim04.school.facturing.persistence.invoice.invoice;

import com.tim04.school.facturing.persistence.client.Client;
import com.tim04.school.facturing.persistence.invoice.invoiceSeries.InvoiceSeries;
import com.tim04.school.facturing.persistence.supplier.Supplier;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "printDate")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String printDate;
    @Column(name = "clientName")
    private String clientName;
    @Column(name = "unityMeasure")
    private String unityMeasure;
    @Column(name = "sum")
    private Integer sum;
    @Column(name = "services")
    private String services;
    @Column(name = "pieces")
    private Integer pieces;
    @Column(name = "unitPrice")
    private Integer unitPrice;
    @Column(name = "totalPrice")
    private Integer totalPrice;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "invoice")
    @JoinColumn(name = "invoiceSeries_id")
    private InvoiceSeries invoiceSeries;

    public static int getCurrentYear() {
        Date currentDate = new Date();
        LocalDate date = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return date.getYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getUnityMeasure() {
        return unityMeasure;
    }

    public void setUnityMeasure(String unityMeasure) {
        this.unityMeasure = unityMeasure;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public InvoiceSeries getInvoiceSeries() {
        return invoiceSeries;
    }

    public void setInvoiceSeries(InvoiceSeries invoiceSeries) {
        this.invoiceSeries = invoiceSeries;
    }
}
