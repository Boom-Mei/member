<template>
  <el-container style="height: 625px; border: 0 solid #eee">
    <el-header style="text-align: right">
      <el-dropdown>
        <i class="el-icon-user-solid" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>查看</el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>王小虎</span>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <v-menu :active.sync="active"></v-menu>
      </el-aside>
      <el-container>
        <el-main>
          <!-- router-view用于挂载匹配到的路由组件（比如：member的内容）-->
          <router-view></router-view>
        </el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
    import VMenu from '@/components/menu'
    export default {
      name: "index",
      components: {
        VMenu
      },
      data() {
        return {
          active: '',
        }
      },
      created: function() {
        // 渲染页面时改变active的值，进入index主页是默认显示member中的内容
        this.active = 'member'
      },
      methods: {
      },
      watch: {
        // 监测active值得变化，当active变化时，push active的值到路由中，路由匹配到实现页面切换
        active(newVal) {
          this.$router.push({
            path: `${this.active}`
          })
        }
      }
    }
</script>

<style scoped>
  /*布局*/
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
