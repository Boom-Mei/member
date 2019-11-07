import instance from './http'

// 登陆
function backLogin(data) {
  return instance.post(process.env.API_HOST + '/member/backMember/backLogin', {
    date: new Date().getTime(),
    member: JSON.stringify(data)
  })
}
// 登出
function backLogout() {
  return instance.get(process.env.API_HOST + '/member/backMember/backLogout', {
    params: {
      date: new Date().getTime()
    }
  })
}

// 用户搜索
function getBackMemberList(data) {
  return instance.get(process.env.API_HOST + '/member/backMember/getBackMemberList', {
    params: {
      date: new Date().getTime(),
      account: data.account,
      phone: data.phone
    }
  })
}

const api = {
  backLogin,
  backLogout,
  getBackMemberList
};

export default api;
