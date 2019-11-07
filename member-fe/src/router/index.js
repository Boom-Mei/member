import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import V404 from '@/pages/404'
import Login from '@/pages/login'
import Index from '@/pages/index'
import Member from '@/pages/member'
import MemberList from '@/pages/member/list'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        roles: ['admin', 'member']
      }
    },
    {
      path: '/index',
      name: 'index',
      component: Index,
      meta: {
        roles: ['admin', 'member']
      },
      children: [
        {
          path: '/memberList',
          name: 'memberList',
          component: MemberList,
          meta: {
            roles: ['admin']
          }
        },
        {
          path: '/member',
          name: 'member',
          component: Member,
          meta: {
            roles: ['admin', 'member']
          }
        },
        {
          path: '/hello',
          name: 'helloWorld',
          component: HelloWorld,
          meta: {
            roles: ['member']
          }
        }
      ]
    },
    {
      path: '/404',
      name: '404',
      component: V404,
      meta: {
        roles: ['admin', 'member']
      }
    }
  ]
})
