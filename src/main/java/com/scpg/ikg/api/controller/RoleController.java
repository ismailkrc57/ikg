package com.scpg.ikg.api.controller;

import com.scpg.ikg.business.abstracts.IRoleService;
import com.scpg.ikg.core.api.ControllerBase;
import com.scpg.ikg.core.entities.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/role")
public class RoleController extends ControllerBase<Role, IRoleService> {

    private final IRoleService iRoleService;

    public RoleController(IRoleService iRoleService) {
        super(iRoleService);
        this.iRoleService = iRoleService;
    }


}
