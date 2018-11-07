package shares;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import shares.data.Stock;
import shares.fetch.GetData;
import shares.util.Window;

import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private String url;
    private static boolean run = false;
    @FXML
    private TableView<Stock> Stock_tableview;
    private ObservableList<Stock> data = FXCollections.observableArrayList();
    @FXML
    private TextField Stock_textfield;
    private GetData getData;

    /**
     * 常规框
     */
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn openPrice;
    @FXML
    private TableColumn closePrice;
    @FXML
    private TableColumn nowPrice;
    @FXML
    private TableColumn highestPrice;
    @FXML
    private TableColumn lowestPrice;
    @FXML
    private TableColumn bidPrice;
    @FXML
    private TableColumn auctionPrice;
    @FXML
    private TableColumn transactionNumber;
    @FXML
    private TableColumn transactionMoney;

    /**
     * 时间
     */
    @FXML
    private TableColumn Date;
    @FXML
    private TableColumn Date_time;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                if (run == true)
                    setTableview_data();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * This method is set the table-view
     */
    public void setTableview_data() throws Exception {
        if (Stock_textfield.getText().equals("")) {
            Window window = new Window();
            window.alert("你得输入东西才行，老弟");
            run = false;
            return;
        }
        data.clear();
        for (String s : getData.getData("http://hq.sinajs.cn/list=" + Stock_textfield.getText()).split("\n")) {
            if (s.equals("FAILED")) {
                Window window = new Window();
                window.alert("请输入正确的股票代码");
                run = false;
                break;
            }
            run = true;
            String[] stock_data = s.split(",");
            data.add(new Stock(stock_data));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            openPrice.setCellValueFactory(new PropertyValueFactory<>("openPrice"));
            closePrice.setCellValueFactory(new PropertyValueFactory<>("closePrice"));
            nowPrice.setCellValueFactory(new PropertyValueFactory<>("nowPrice"));
            highestPrice.setCellValueFactory(new PropertyValueFactory<>("highestPrice"));
            lowestPrice.setCellValueFactory(new PropertyValueFactory<>("lowestPrice"));
            bidPrice.setCellValueFactory(new PropertyValueFactory<>("bidPrice"));
            auctionPrice.setCellValueFactory(new PropertyValueFactory<>("auctionPrice"));
            transactionNumber.setCellValueFactory(new PropertyValueFactory<>("transactionNumber"));
            transactionMoney.setCellValueFactory(new PropertyValueFactory<>("transactionMoney"));
            Date.setCellValueFactory(new PropertyValueFactory<>("Date_"));
            Date_time.setCellValueFactory(new PropertyValueFactory<>("Date_time_"));

            Stock_tableview.setItems(data);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
            service.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.SECONDS);
            getData = new GetData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
