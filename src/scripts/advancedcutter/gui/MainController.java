package scripts.advancedcutter.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import scripts.advancedcutter.Main;
import scripts.advancedcutter.api.gui.AbstractGUIController;
import scripts.advancedcutter.api.utilities.Vars;

public class MainController extends AbstractGUIController {

	@FXML
	private Button startBtn, setTreeSpotWalkBtn, setFirstBankTileBtn, setSecondBankTileBtn, setFirstTreeAreaBtn,
			setSecondTreeAreaBtn, saveBtn, loadBtn;
	@FXML
	private ComboBox<String> methodCombo, locationCombo, treeCombo;

	@FXML
	private ListView<String> optionListView;

	@FXML
	private AnchorPane customChopPane, mainPane;

	@FXML
	private TextField treeSpotWalkTile, treeAreaFirstTile, treeAreaSecondTile, bankAreafirstTile, bankAreaSecondTile;

	@FXML
	private CheckBox powerchop, progressiveLeveling;

	@FXML
	private ImageView image;

	private ObservableList<String> methodList, treeList, locationList;

	public void buttonAction(ActionEvent event) {
		Node node = (Node) event.getSource();
		if (node.getId().equals(this.startBtn.getId())) {
			this.startBtnEvent();
		}
		if (node.getId().equals(this.saveBtn.getId())) {
			this.saveBtnEvent();
		}
		if (node.getId().equals(this.loadBtn.getId())) {
			this.loadBtnEvent();
		}
		if (node.getId().equals(this.treeSpotWalkTile.getId())) {

		}
		if (node.getId().equals(this.setFirstBankTileBtn.getId())) {

		}
		if (node.getId().equals(this.setFirstBankTileBtn.getId())) {

		}
		if (node.getId().equals(this.setFirstTreeAreaBtn.getId())) {

		}
		if (node.getId().equals(this.setSecondTreeAreaBtn.getId())) {

		}
	}

	private void loadBtnEvent() {
		// load settings
	}

	private void saveBtnEvent() {
		// save settings
	}

	private void startBtnEvent() {
		Vars.start = true;
		Main.gui.close();
	}

	private void shouldDisableMain(boolean disable) {
		for (Node node : this.mainPane.getChildren()) {
			if (node instanceof Button || node instanceof ComboBox || node instanceof TextField
					|| node instanceof ListView) {
				if (node instanceof Button) {
					Button btn = (Button) node;
					if (!btn.getId().equals(this.startBtn.getId()))
						node.setDisable(disable);
				} else {
					node.setDisable(disable);
				}
			}
		}
	}

	private void shouldDisableCustom(boolean disable) {
		for (Node node : this.customChopPane.getChildren()) {
			if (node instanceof Button || node instanceof ComboBox || node instanceof TextField
					|| node instanceof ListView) {
				if (node instanceof Button) {
					node.setDisable(disable);
				} else {
					node.setDisable(disable);
				}
			}
		}
	}

	public void progressiveLevelingSelected(ActionEvent event) {
		if (this.progressiveLeveling.isSelected()) {
			this.shouldDisableMain(true);
			this.shouldDisableCustom(true);
		} else {
			this.shouldDisableMain(false);
			this.shouldDisableCustom(false);
		}
	}

	public void powerChopSelected(ActionEvent event) {
		for (Node node : this.customChopPane.getChildren()) {
			if (node instanceof Button) {
				if (methodCombo.getSelectionModel().getSelectedIndex() == 0) {
					if (this.powerchop.isSelected()) {
						Button btn = (Button) node;
						if (btn.getId().equals(this.setFirstBankTileBtn.getId())
								|| btn.getId().equals(this.setSecondBankTileBtn.getId())) {
							node.setDisable(true);
						}
					} else {
						node.setDisable(false);
					}
				} else {
					node.setDisable(true);
				}
			}
		}
	}

	public void treeComboChanged(ActionEvent event) {
		this.optionListView.getItems().clear();
		if (this.locationCombo.getSelectionModel().getSelectedItem() == null) {
			this.optionListView.getItems().add("Please select");
			this.optionListView.getItems().add("a location");
		}
	}

	public void methodComboChanged(ActionEvent event) {
		this.optionListView.getItems().clear();
		this.powerchop.setSelected(false);
		if (this.treeCombo.getSelectionModel().getSelectedItem() == null) {
			this.optionListView.getItems().add("Please select");
			this.optionListView.getItems().add("a tree");
		}
		for (Node node : this.customChopPane.getChildren()) {
			if (node instanceof Button) {
				if (methodCombo.getSelectionModel().getSelectedIndex() == 0) {
					this.locationCombo.setDisable(true);
					node.setDisable(false);
				} else {
					this.locationCombo.setDisable(false);
					node.setDisable(true);
				}
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.methodList = FXCollections.observableArrayList("Custom chop", "Standard chop");
		this.treeList = FXCollections.observableArrayList("Tree", "Oak", "Willow", "Yew", "Magic tree");
		this.locationList = FXCollections.observableArrayList("Varrock", "Falador", "Catherby", "Draynor", "Lumbridge");
		this.optionListView.getItems().add("Please choose");
		this.optionListView.getItems().add("options from");
		this.optionListView.getItems().add("the comboxes.");
		this.image.setImage(new Image("http://i.imgur.com/umqvzoH.jpg"));
		if (this.methodList.size() > 0) {
			this.methodCombo.setItems(this.methodList);
		}
		if (this.treeList.size() > 0) {
			this.treeCombo.setItems(this.treeList);
		}
		if (this.locationList.size() > 0) {
			this.locationCombo.setItems(this.locationList);
		}
	}

}