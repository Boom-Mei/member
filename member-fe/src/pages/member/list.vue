<template>
    <el-row>
      <!--搜索条件-->
      <el-col>
        <el-form :inline="true" :model="memberSearch">
          <el-form-item label="账号">
            <el-input v-model="memberSearch.account" clearable></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="memberSearch.phone" clearable></el-input>
            <!--操作按钮-->
            <el-button type="primary" icon="el-icon-search" @click="search" round size="medium">查询</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col>
        <el-table
          ref="singleTable"
          :data="tableData"
          border
          highlight-current-row
          @current-change="handleCurrentChange"
          class="table—style"
          height="250">
          <el-table-column
            fixed
            type="index"
            width="48">
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            width="150">
          </el-table-column>
          <el-table-column
            prop="account"
            label="账号"
            width="150">
          </el-table-column>
          <el-table-column
            prop="phone"
            label="手机号"
            width="150">
          </el-table-column>
          <el-table-column
            prop="sex"
            label="性别"
            width="100">
            <template slot-scope="scope">
              <span v-if="scope.row.sex === 0">男</span>
              <span v-if="scope.row.sex === 1">女</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="email"
            label="邮箱"
            width="200">
          </el-table-column>
          <el-table-column
            prop="createEmp"
            label="创建人"
            width="150">
          </el-table-column>
          <el-table-column
            prop="createTime"
            label="创建时间"
            width="200">
          </el-table-column>
          <el-table-column
            prop="remark"
            label="备注"
            width="150">
          </el-table-column>
        </el-table>
      </el-col>
<!--      <el-col>-->
<!--        <el-table-->
<!--          ref="multipleTable"-->
<!--          :data="tableData"-->
<!--          border-->
<!--          @current-change="handleSelectionChange"-->
<!--          class="table—style"-->
<!--          height="250">-->
<!--          <el-table-column-->
<!--            fixed-->
<!--            label="序号"-->
<!--            type="selection"-->
<!--            width="44">-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="name"-->
<!--            label="姓名"-->
<!--            width="150">-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="account"-->
<!--            label="账号"-->
<!--            width="150">-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="phone"-->
<!--            label="手机号"-->
<!--            width="150">-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="sex"-->
<!--            label="性别"-->
<!--            width="100">-->
<!--            <template slot-scope="scope">-->
<!--              <span v-if="scope.row.sex === 0">男</span>-->
<!--              <span v-if="scope.row.sex === 1">女</span>-->
<!--            </template>-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="email"-->
<!--            label="邮箱"-->
<!--            width="200">-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="createEmp"-->
<!--            label="创建人"-->
<!--            width="150">-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="createTime"-->
<!--            label="创建时间"-->
<!--            width="200">-->
<!--          </el-table-column>-->
<!--          <el-table-column-->
<!--            prop="remark"-->
<!--            label="备注"-->
<!--            width="150">-->
<!--          </el-table-column>-->
<!--        </el-table>-->
<!--      </el-col>-->
    </el-row>
</template>

<script>
    export default {
      name: "list",
      data() {
        return {
          tableData: [],
          memberSearch: {
            account: '',
            phone: ''
          },
          currentRow: null,
          // multipleSelection: []
        }
      },
      created:function() {
        this.search();
      },
      methods: {
        search() {
          this.$api.getBackMemberList(this.memberSearch)
            .then(response => {
              if(response.data.success === true) {
                this.tableData = response.data.data;
              } else {
                this.$message('未登录！');
                window.location = '/';
              }
            })
            .catch(error => {
              this.$message('发生错误了！');
            })
        },
        setCurrent(row) {
          this.$refs.singleTable.setCurrentRow(row);
        },
        // toggleSelection(rows) {
        //   if (rows) {
        //     rows.forEach(row => {
        //       this.$refs.multipleTable.toggleRowSelection(row);
        //     });
        //   } else {
        //     this.$refs.multipleTable.clearSelection();
        //   }
        // },
        handleCurrentChange(val) {
          this.currentRow = val;
        },
        // handleSelectionChange(val) {
        //   this.multipleSelection = val;
        // }
      }
    }
</script>

<style scoped>

</style>
