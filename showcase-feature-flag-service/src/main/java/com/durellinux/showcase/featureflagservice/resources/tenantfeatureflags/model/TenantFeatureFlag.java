package com.durellinux.showcase.featureflagservice.resources.tenantfeatureflags.model;

import com.durellinux.showcase.commons.argutils.ArgUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(TenantFeatureFlag.TenantFeatureFlagId.class)
public class TenantFeatureFlag {

    public static class TenantFeatureFlagId implements Serializable {
        private String tenant;
        private String name;

        protected TenantFeatureFlagId() {
        }

        public TenantFeatureFlagId(String tenant, String name) {
            ArgUtils.assertNotNull(tenant);
            ArgUtils.assertNotNull(name);
            this.tenant = tenant;
            this.name = name;
        }

        public String getTenant() {
            return tenant;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TenantFeatureFlagId)) return false;

            TenantFeatureFlagId that = (TenantFeatureFlagId) o;

            if (!getTenant().equals(that.getTenant())) return false;
            return getName().equals(that.getName());
        }

        @Override
        public int hashCode() {
            int result = getTenant().hashCode();
            result = 31 * result + getName().hashCode();
            return result;
        }
    }

    @Id
    @Column(nullable = false)
    private String tenant;

    @Id
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean value;

    protected TenantFeatureFlag() {
    }

    public TenantFeatureFlag(String tenant, String name, Boolean value) {
        ArgUtils.assertNotNull(tenant);
        ArgUtils.assertNotNull(name);
        ArgUtils.assertNotNull(value);

        this.tenant = tenant;
        this.name = name;
        this.value = value;
    }

    public String getTenant() {
        return tenant;
    }

    public String getName() {
        return name;
    }

    public Boolean getValue() {
        return value;
    }
}
