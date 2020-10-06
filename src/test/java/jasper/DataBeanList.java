package jasper;

import java.util.ArrayList;

public class DataBeanList {
    public ArrayList<DataBean> getDataBeanList() {
        ArrayList<DataBean> dataBeans = new ArrayList<DataBean>();

        dataBeans.add(produce("Кровля", "Технониколь", "м",
                10, 200, 3000));

        return dataBeans;
    }

    private DataBean produce(String work, String material, String mesaure,
                             Integer quantity, Integer costWithNDS, Integer estimatedCost) {
        DataBean dataBean = new DataBean();
        dataBean.setWork(work);
        dataBean.setMaterial(material);
        dataBean.setMesaure(mesaure);
        dataBean.setQuantity(quantity);
        dataBean.setCostWithNDS(costWithNDS);
        dataBean.setEstimatedCost(estimatedCost);

        return dataBean;
    }
}
