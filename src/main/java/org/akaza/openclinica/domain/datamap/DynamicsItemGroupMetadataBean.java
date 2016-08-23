package org.akaza.openclinica.domain.datamap;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dyn_item_group_metadata")
@GenericGenerator(name = "id-generator", strategy = "native", parameters = { @Parameter(name = "sequence", value = "dyn_item_group_metadata_id_seq") })
public class DynamicsItemGroupMetadataBean extends AbstractMutableDomainObject {

    private boolean showGroup;
    private int eventCrfId;
    private int itemGroupMetadataId;
    private int itemGroupId;
    private int passedDde;

    public DynamicsItemGroupMetadataBean() {
        passedDde = 0;
    }

    public DynamicsItemGroupMetadataBean(ItemGroupMetadata metadataBean, EventCrf eventCrfBean) {
        setEventCrfId(eventCrfBean.getEventCrfId());
        setItemGroupMetadataId(metadataBean.getItemGroupMetadataId());
        setItemGroupId(metadataBean.getItemGroup().getItemGroupId());
        setShowGroup(metadataBean.getShowGroup());
        setPassedDde(0);
    }

    public boolean isShowGroup() {
        return showGroup;
    }

    public void setShowGroup(boolean showGroup) {
        this.showGroup = showGroup;
    }

    public int getPassedDde() {
        return passedDde;
    }

    public void setPassedDde(int passedDde) {
        this.passedDde = passedDde;
    }

    public int getEventCrfId() {
        return eventCrfId;
    }

    public void setEventCrfId(int eventCrfId) {
        this.eventCrfId = eventCrfId;
    }

    public int getItemGroupMetadataId() {
        return itemGroupMetadataId;
    }

    public void setItemGroupMetadataId(int itemGroupMetadataId) {
        this.itemGroupMetadataId = itemGroupMetadataId;
    }

    public int getItemGroupId() {
        return itemGroupId;
    }

    public void setItemGroupId(int itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

}
